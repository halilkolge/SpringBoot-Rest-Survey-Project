package com.example.anketguncel.service;

import com.example.anketguncel.dto.AnketDto;
import com.example.anketguncel.response.ResponseItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnketService {

    List<AnketDto> takimAnket = new ArrayList<>();
    List<AnketDto> mutluAnket = new ArrayList<>();
    Integer tempTakim=1;
    Integer tempMutlu=1;

    public ResponseItem create(AnketDto anketDto){
        ResponseItem responseItem = new ResponseItem();
        try {
            if (anketDto.getTakim() == null) {
                anketDto.setId(tempMutlu);
                mutluAnket.add(anketDto);
                tempMutlu++;
                responseItem.setResult(true);
                responseItem.setMessage("İşlem Başarılı.");
            } else {
                anketDto.setId(tempTakim);
                takimAnket.add(anketDto);
                tempTakim++;
                responseItem.setResult(true);
                responseItem.setMessage("İşlem Başarılı.");
            }
            return responseItem;
        }catch (Exception e){
            e.printStackTrace();
            responseItem.setResult(false);
            responseItem.setMessage("İşlem Başarısız.");
            return responseItem;
        }
    }

    public List<AnketDto> listele(int secim){
        try {
            if (secim == 1) {
                return takimAnket;
            } else {
                return mutluAnket;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public AnketDto findById(int id, int secim){
        if (secim == 1) {
            for (int i = 0; i < takimAnket.size(); i++) {
                if (id == takimAnket.get(i).getId()) {
                    return takimAnket.get(i);
                }
            }
            return null;
        }else {
            for (int i=0; i<mutluAnket.size(); i++){
                if (id == mutluAnket.get(i).getId()){
                    return mutluAnket.get(i);
                }
            }
            return null;
        }
    }

    public ResponseItem update(AnketDto anketDto){

        ResponseItem responseItem = new ResponseItem();

        if (anketDto.getTakim() == null){

            for (int i = 0; i < mutluAnket.size(); i++) {
                if (anketDto.getId() == mutluAnket.get(i).getId()) {
                    mutluAnket.set(i, anketDto);
                    responseItem.setResult(true);
                    responseItem.setMessage("İşlem Başarılı.");
                    return responseItem;
                }
            }

//             mutluAnket.set(anketDto.getId()-1,anketDto);
//             responseItem.setResult(true);
//             responseItem.setMessage("İşlem Başarılı.");
            return responseItem;
        }else{
            for (int i = 0; i < takimAnket.size(); i++) {
                if (anketDto.getId() == takimAnket.get(i).getId()) {
                    takimAnket.set(i, anketDto);
                    responseItem.setResult(true);
                    responseItem.setMessage("İşlem Başarılı.");
                    return responseItem;
                }
            }
            return responseItem;
        }
    }

    public ResponseItem delete(int id, int secim) {
        ResponseItem responseItem = new ResponseItem();
        try {
            if (secim == 1) {
                for (int i = 0; i < takimAnket.size(); i++) {
                    if (id == takimAnket.get(i).getId()) {
                        takimAnket.remove(i);
                        responseItem.setResult(true);
                        responseItem.setMessage("İşlem Başarılı.");
                        return responseItem;
                    }
                }
            } else {
                for (int i = 0; i < mutluAnket.size(); i++) {
                    if (id == mutluAnket.get(i).getId()) {
                        mutluAnket.remove(i);
                        responseItem.setResult(true);
                        responseItem.setMessage("İşlem Başarılı.");
                        return responseItem;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            responseItem.setResult(false);
            responseItem.setMessage("İşlem Başarısız!");
            return responseItem;
        }
    }
}

