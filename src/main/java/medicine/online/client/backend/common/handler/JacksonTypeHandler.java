package medicine.online.client.backend.common.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JacksonTypeHandler extends BaseTypeHandler<List<Integer>> {
    private static final Logger logger = LoggerFactory.getLogger(JacksonTypeHandler.class);
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    // 设置非空参数
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<Integer> parameter, JdbcType jdbcType) throws SQLException {
        try {
            String jsonString = objectMapper.writeValueAsString(parameter);
            logger.info("设置参数时转换的JSON字符串: " + jsonString);
            ps.setString(i, jsonString);
        } catch (JsonProcessingException e) {
            logger.error("参数转换为JSON字符串时出错", e);
            throw new SQLException(e);
        }
    }

    // 根据列名获取结果
    @Override
    public List<Integer> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        try {
            String jsonString = rs.getString(columnName);
            logger.info("从数据库获取的原始JSON字符串: " + jsonString);
            if (jsonString!= null) {
                List<Integer> result = objectMapper.readValue(jsonString, objectMapper.getTypeFactory().constructCollectionType(List.class, Integer.class));
                logger.info("转换后的List<Integer>结果: " + result);
                return result;
            }
            return null;
        } catch (JsonProcessingException e) {
            logger.error("解析JSON字符串时出错", e);
            throw new SQLException(e);
        }
    }

    // 根据列索引获取结果
    @Override
    public List<Integer> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        // 逻辑同根据列名获取结果的方法
        try {
            String jsonString = rs.getString(columnIndex);
            logger.info("从数据库获取的原始JSON字符串（按索引）: " + jsonString);
            if (jsonString!= null) {
                List<Integer> result = objectMapper.readValue(jsonString, objectMapper.getTypeFactory().constructCollectionType(List.class, Integer.class));
                logger.info("转换后的List<Integer>结果（按索引）: " + result);
                return result;
            }
            return null;
        } catch (JsonProcessingException e) {
            logger.error("解析JSON字符串时出错（按索引）", e);
            throw new SQLException(e);
        }
    }

    // 处理存储过程调用的结果
    @Override
    public List<Integer> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        // 同样的处理逻辑
        try {
            String jsonString = cs.getString(columnIndex);
            logger.info("从存储过程获取的原始JSON字符串: " + jsonString);
            if (jsonString!= null) {
                List<Integer> result = objectMapper.readValue(jsonString, objectMapper.getTypeFactory().constructCollectionType(List.class, Integer.class));
                logger.info("转换后的List<Integer>结果（存储过程）: " + result);
                return result;
            }
            return null;
        } catch (JsonProcessingException e) {
            logger.error("解析JSON字符串时出错（存储过程）", e);
            throw new SQLException(e);
        }
    }
}