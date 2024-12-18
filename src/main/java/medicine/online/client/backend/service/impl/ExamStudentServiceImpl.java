package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.common.cache.RedisKeys;
import org.springframework.stereotype.Service;
import medicine.online.client.backend.mapper.ExamStudentMapper;
import medicine.online.client.backend.model.entity.ExamStudent;
import medicine.online.client.backend.service.IExamStudentService;
import medicine.online.client.backend.common.cache.RedisCache;
import medicine.online.client.backend.common.exception.ServerException;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@AllArgsConstructor
public class ExamStudentServiceImpl extends ServiceImpl<ExamStudentMapper, ExamStudent> implements IExamStudentService {

    private final RedisCache redisCache;

    @Override
    public boolean startExam(Integer examId, Integer studentId) {
        // 检查是否已经开始考试
        ExamStudent existingRecord = baseMapper.findByExamIdAndStudentId(examId, studentId);
        if (existingRecord != null) {
            return false;
        }
        
        // 创建新的考试记录
        ExamStudent examStudent = new ExamStudent();
        examStudent.setQuizExamId(examId);
        examStudent.setStudentId(studentId);
        
        // 保存记录
        boolean saved = save(examStudent);
        if (!saved) {
            throw new ServerException("创建考试记录失败");
        }
        
        // 存储到Redis，设置过期时间（6小时）
        String key = RedisKeys.getQuizUserPaperId(examId);
        redisCache.set(key, examId, RedisCache.HOUR_SIX_EXPIRE);
        log.info("考试记录已缓存，key: {}, examId: {}", key, examId);
        
        return true;
    }

    @Override
    public String getQuizUserDetail(String detail) {
        String key = RedisKeys.getQuizUserDetail(detail);
        Object value = redisCache.get(key);
        return value != null ? value.toString() : null;
    }

    @Override
    public void saveQuizUserPaperId(Integer examId) {
        String key = RedisKeys.getQuizUserPaperId(examId);
        redisCache.set(key, examId, RedisCache.HOUR_SIX_EXPIRE);
        log.info("试卷访问记录已缓存，key: {}, examId: {}", key, examId);
    }
} 