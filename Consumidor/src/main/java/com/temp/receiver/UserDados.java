package com.temp.receiver;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

@Configuration
@Service
@EnableScheduling
public class UserDados implements Serializable {
    public int id_drone;
    public ArrayList<Integer> latitude =  new ArrayList<Integer>();
    public ArrayList<Integer> longitude =  new ArrayList<Integer>();
    public ArrayList<Integer> temperatura =  new ArrayList<Integer>();
    public ArrayList<Integer> umidade =  new ArrayList<Integer>();
    public String myCheckbox;

    public String enviaEmail;

    public UserDados(int id_drone, Integer latitude, Integer longitude, Integer temperatura, Integer umidade, String myCheckbox, String enviaEmail){
        this.id_drone = id_drone;
        addLatitude(latitude);
        addLongitude(longitude);
        addTemperatura(temperatura);
        addUmidade(umidade);
        this.myCheckbox = myCheckbox;
        this.enviaEmail = enviaEmail;

    }

    public UserDados (){

    }

    public int getId_drone() {
        return id_drone;
    }

    public void setId_drone(int id_drone) {
        this.id_drone = id_drone;
    }

    public ArrayList<Integer> getLatitude() {
        return latitude;
    }

    public void setLatitude(ArrayList<Integer> latitude) {
        this.latitude = latitude;
    }

    public ArrayList<Integer> getLongitude() {
        return longitude;
    }

    public void setLongitude(ArrayList<Integer> longitude) {
        this.longitude = longitude;
    }

    public ArrayList<Integer> getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(ArrayList<Integer> temperatura) {
        this.temperatura = temperatura;
    }

    public ArrayList<Integer> getUmidade() {
        return umidade;
    }

    public void setUmidade(ArrayList<Integer> umidade) {
        this.umidade = umidade;
    }

    public void clearTemperatura(){
        this.temperatura.clear();
    }

    public void clearUmidade(){
        this.umidade.clear();
    }

    public void clearLongitude(){
        this.longitude.clear();
    }

    public void clearLatitude(){
        this.latitude.clear();
    }

    public void addTemperatura(Integer tenperatura){
        this.temperatura.add(tenperatura);
    }

    public void addUmidade(Integer umidade){
        this.umidade.add(umidade);
    }

    public void addLongitude(Integer longitude){
        this.longitude.add(longitude);
    }

    public void addLatitude(Integer latitude){
        this.latitude.add(latitude);
    }

    public String getMyCheckbox() {
        return myCheckbox;
    }

    public void setMyCheckbox(String myCheckbox) {
        this.myCheckbox = myCheckbox;
    }

    public String getEnviaEmail() {
        return enviaEmail;
    }

    public void setEnviaEmail(String enviaEmail) {
        this.enviaEmail = enviaEmail;
    }

    public void imprime(){
        System.out.println("");
        System.out.println("----------------------------------------------");
        System.out.println("Alerta do drone " + this.id_drone);

        /*String mensagem = """
                Umidades: %i
                Temperaturas: %d
                Latitudes: %d
                Longitudes: %d
                Ativar Rastreiamento: %S
                """.formatted(this.umidade,
                this.temperatura,
                this.latitude,
                this.longitude,
                this.myCheckbox);

        System.out.println(mensagem);*/
        System.out.println("Umidades: " + this.umidade);
        System.out.println("Temperaturas: " + this.temperatura);
        System.out.println("Latitudes: " + this.latitude);
        System.out.println("Longitude: " + this.longitude);
        System.out.println("Ativar Rastreiamento: " + this.myCheckbox);
        System.out.println("----------------------------------------------");
    }

    public String texto(){

        String mensagem = """
                ----------------------------------------------
                Alerta do drone  %S
                
                Umidades: %S
                Temperaturas: %S
                Latitudes: %S
                Longitudes: %S
                Ativar Rastreiamento: %S
                """.formatted(this.id_drone,
                        this.umidade,
                this.temperatura,
                this.latitude,
                this.longitude,
                this.myCheckbox);
        return mensagem;

    }

}
