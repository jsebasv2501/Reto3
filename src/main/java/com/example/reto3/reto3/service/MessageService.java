package com.example.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reto3.reto3.model.Message;
import com.example.reto3.reto3.repository.MessageRepository;

@Service
public class MessageService {
    

    @Autowired
    private MessageRepository messageRepository;


    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message m){
        if(m.getIdMessage() == null){
            return messageRepository.save(m);
        }else{
            Optional<Message> mAux = messageRepository.getMessage(m.getIdMessage());
            if(mAux.isEmpty()){
                return messageRepository.save(m);
            }else{
                return m;
            }
        }
    }

    public Message update(Message m){
        if(m.getIdMessage() != null){
            Optional<Message> mAux = messageRepository.getMessage(m.getIdMessage());
            if(!mAux.isEmpty()){
                if(m.getMessageText() != null){
                    mAux.get().setMessageText(m.getMessageText());
                }
                if(m.getMachine() != null){
                    mAux.get().setMachine(m.getMachine());
                }

                messageRepository.save(mAux.get());
                return mAux.get();
            }else{
                return m;
            }
        }else{
            return m;
        }
    }

    public boolean deleteMessage(int id){
        Boolean aBoolean = getMessage(id).map(message -> {
            messageRepository.borrar(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    

}
