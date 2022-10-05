package com.example.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reto3.reto3.model.Clientes;
import com.example.reto3.reto3.repository.ClientesRepository;

@Service
public class ClientesService {
    
    @Autowired
    private ClientesRepository clientesRepository;

    public List<Clientes> getAll(){
        return clientesRepository.getAll();
    }

    public Optional<Clientes> getCliente(int id){
        return clientesRepository.getCliente(id);
    }

    public Clientes save(Clientes c){
        if(c.getIdClient() == null){
            return clientesRepository.save(c);
        }else{
            Optional<Clientes> cAux = clientesRepository.getCliente(c.getIdClient());
            if(cAux.isEmpty()){
                return clientesRepository.save(c);
            }else{
                return c;
            }
        }
    }

    public Clientes update(Clientes c){
        if(c.getIdClient() != null){
            Optional<Clientes> cAux = clientesRepository.getCliente(c.getIdClient());
            if(!cAux.isEmpty()){
                if(c.getName() != null){
                    cAux.get().setName(c.getName());
                }

                if(c.getAge() != null){
                    cAux.get().setAge(c.getAge());
                }

                if(c.getEmail() != null){
                    cAux.get().setEmail(c.getEmail());
                }

                if(c.getPassword() != null){
                    cAux.get().setPassword(c.getPassword());
                }

                clientesRepository.save(cAux.get());
                return cAux.get();
            }else{
                return c;
            }
        }else{
            return c;
        }
    }

    public boolean deleteCliente(int id){
        Boolean aBoolean = getCliente(id).map(cliente -> {
            clientesRepository.borrar(cliente);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
