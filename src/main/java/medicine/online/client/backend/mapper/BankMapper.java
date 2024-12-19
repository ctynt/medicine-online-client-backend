package medicine.online.client.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.Bank;
import org.apache.ibatis.annotations.*;

/**
 * @author: minder
 * @createTime: 2024/12/18 1:24
 * @description:
 **/
public interface BankMapper extends BaseMapper<Bank> {
    // 获取题目及其选项
    @Select("SELECT b.*, bo.* FROM t_quiz_bank b " +
            "LEFT JOIN t_quiz_bank_option bo ON b.pk_id = bo.bank_id " +
            "WHERE b.pk_id = #{pkId}")
    @Results({
            @Result(property = "pkId", column = "pk_id"),
            @Result(property = "bankOptions", column = "pk_id",
                    many = @Many(select = "medicine.online.client.backend.mapper.BankOptionMapper.findByBankId"))
    })
    Bank getBankWithOptions(@Param("pkId") Integer pkId);
}
