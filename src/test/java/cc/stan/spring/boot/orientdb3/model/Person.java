package cc.stan.spring.boot.orientdb3.model;

import cc.stan.spring.boot.orientdb3.annotation.Ignore;
import cc.stan.spring.boot.orientdb3.annotation.Index;
import cc.stan.spring.boot.orientdb3.annotation.Vertex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 人物
 *
 * @author magic.hualong(at)gmail.com
 * @since 1.0
 */
@Vertex
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Person {
    /** 身份证号 */
    @Index
    private Long cardId;

    /** 姓 */
    private String familyName;
    /** 名 */
    private String firstName;

    /** 简短的描述 */
    @Ignore
    private String describe;

    /** 出生阳历 */
    @Ignore
    private LocalDateTime birthday;
}
