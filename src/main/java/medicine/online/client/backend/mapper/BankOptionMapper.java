package medicine.online.client.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.BankOption;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: minder
 * @createTime: 2024/12/18 1:40
 * @description:
 **/

public interface BankOptionMapper extends BaseMapper<BankOption> {
    @Select("SELECT * FROM t_quiz_bank_option WHERE bank_id = #{bankId}")
    List<BankOption> findByBankId(@Param("bankId") Integer bankId);
}
