package com.imet_bot.repos;

import com.imet_bot.entities.Command;
import com.imet_bot.entities.Stage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StageRepository extends MongoRepository<Stage, String> {
    public Stage findStageByCommand(String command);
    public Stage findStageByStageName(String stageName);
}
