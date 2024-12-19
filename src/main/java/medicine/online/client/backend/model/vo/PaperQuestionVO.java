package medicine.online.client.backend.model.vo;

import lombok.Data;

/**
 * @author: minder
 * @createTime: 2024/12/18 10:08
 * @description:
 **/
@Data
public class PaperQuestionVO {
    private Integer paperId;
    private String paperTitle;
    private Integer timeLimit;
    private Integer simpleScore;    // 单选题分数
    private Integer multipleScore;  // 多选题分数
    private Integer blankScore;     // 填空题分数
    private Integer passScore;      // 及格分数
    private Integer questionId;     // 题目ID
    private Integer optionType;     // 题目类型
    private String correctAnswer;   // 正确答案
}
