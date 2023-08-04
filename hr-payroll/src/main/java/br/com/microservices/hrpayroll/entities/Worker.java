package br.com.microservices.hrpayroll.entities;


import java.io.Serializable;


public class Worker implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;
    private String name;
    private Double dailyIncome;

    public Worker() {
    }

    public Worker(Long id, String nome, Double dailyIncome) {
        this.id = id;
        this.name = nome;
        this.dailyIncome = dailyIncome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public Double getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(Double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }


}
