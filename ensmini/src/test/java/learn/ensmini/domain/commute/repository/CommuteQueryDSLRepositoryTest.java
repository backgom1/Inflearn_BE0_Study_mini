package learn.ensmini.domain.commute.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import learn.ensmini.domain.commute.dto.MinuteList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("dev")
@Transactional
class CommuteQueryDSLRepositoryTest {


    @Autowired
    EntityManager em;

    JPAQueryFactory queryFactory;

    @Autowired
    private CommuteQueryDSLRepository commuteQueryDSLRepository;
    @DisplayName("쿼리 테스트")
    @Test
    void test() {
        List<MinuteList> minuteLists = commuteQueryDSLRepository.calculateWorkMinute(1L);
        assertThat(minuteLists).hasSize(3);
    }
}