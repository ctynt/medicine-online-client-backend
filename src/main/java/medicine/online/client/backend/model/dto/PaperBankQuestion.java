package medicine.online.client.backend.model.dto;

import lombok.Data;
import medicine.online.client.backend.model.entity.BankOption;

import java.util.List;

/**
 * @author: minder
 * @createTime: 2024/12/15 20:43
 * @description:
 **/
@Data
public class PaperBankQuestion {
    private Integer pkId;
    private Integer optionType;
    private String question;
    private List<BankOptionDTO> options;
}
