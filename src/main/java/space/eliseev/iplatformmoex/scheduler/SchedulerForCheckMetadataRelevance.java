package space.eliseev.iplatformmoex.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import space.eliseev.iplatformmoex.service.CheckMetadataService;

@Component
@RequiredArgsConstructor
public class SchedulerForCheckMetadataRelevance {

    private final CheckMetadataService checkMetadataService;

    @Scheduled(cron = "0 13 20 * * *")
    public void checkTableEngineForRelevance() {
        checkMetadataService.checkEngine();
    }

    @Scheduled(cron = "0 1 9 * * *")
    public void checkTableMarketForRelevance() {
        checkMetadataService.checkMarket();
    }

    @Scheduled(cron = "0 2 9 * * *")
    public void checkBoardTableForRelevance() {
        checkMetadataService.checkBoard();
    }

    @Scheduled(cron = "0 3 9 * * *")
    public void checkBoardGroupTableForRelevance() {
        checkMetadataService.checkBoardGroup();
    }

    @Scheduled(cron = "0 4 9 * * *")
    public void checkDurationTableForRelevance() {
        checkMetadataService.checkDuration();
    }

    @Scheduled(cron = "0 5 9 * * *")
    public void checkSecurityTypeTableForRelevance() {
        checkMetadataService.checkSecurityType();
    }

    @Scheduled(cron = "0 6 9 * * *")
    public void checkSecurityGroupTableForRelevance() {
        checkMetadataService.checkSecurityGroup();
    }

    @Scheduled(cron = "0 7 9 * * *")
    public void checkSecurityCollectionTable() {
        checkMetadataService.checkSecurityCollection();
    }
}
