/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseBroker;

import Domain.GeneralEntity;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author User
 */
public abstract class DatabaseBroker {

    public abstract boolean makeConnection();
    public abstract boolean insertRecord(GeneralEntity generalEntity);
    public abstract boolean insertCompositeRecord(GeneralEntity generalEntity);
    public abstract boolean updateRecord(GeneralEntity generalEntity, GeneralEntity generalEntityId);
    public abstract boolean updateRecord(GeneralEntity generalEntity);
    public abstract boolean deleteRecord(GeneralEntity generalEntity);
    public abstract boolean deleteRecords(GeneralEntity generalEntity, String where);
    public abstract GeneralEntity findRecord(GeneralEntity generalEntity);
    public abstract List<GeneralEntity> findRecord(GeneralEntity generalEntity, String where);
    public abstract boolean commitTransation();
    public abstract boolean rollbackTransation();
    public abstract void closeConnection();
    public abstract boolean getCounter(GeneralEntity generalEntity, AtomicInteger counter);
    public abstract boolean increaseCounter(GeneralEntity generalEntity, AtomicInteger counter);
    public abstract GeneralEntity getRecord(GeneralEntity generalEntity, int index);
    public abstract int getRecordsNumber(GeneralEntity generalEntity);

}
