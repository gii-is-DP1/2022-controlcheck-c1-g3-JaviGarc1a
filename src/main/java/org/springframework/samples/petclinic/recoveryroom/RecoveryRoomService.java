package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.util.StringUtils;

@Service
public class RecoveryRoomService {

    RecoveryRoomRepository recoveryRoomRepository;

    @Autowired
    public RecoveryRoomService(RecoveryRoomRepository recoveryRoomRepository) {
        this.recoveryRoomRepository = recoveryRoomRepository;
    }

    @Transactional(readOnly = true)
    public List<RecoveryRoom> getAll(){
        return this.recoveryRoomRepository.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return this.recoveryRoomRepository.findAllRecoveryRoomTypes();
    }

    @Transactional(readOnly = true)
    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return this.recoveryRoomRepository.getRecoveryRoomType(typeName);
    }

    @Transactional(rollbackFor = DuplicatedRoomNameException.class)
    public RecoveryRoom save(RecoveryRoom recoveryRoom) throws DuplicatedRoomNameException {
        List<RecoveryRoom> lr = recoveryRoomRepository.findAll();
        if (lr.contains(recoveryRoom)) {
            throw new DuplicatedRoomNameException();
        } else {
            recoveryRoomRepository.save(recoveryRoom);
        }
        return recoveryRoomRepository.save(recoveryRoom);       
    }
    
}
