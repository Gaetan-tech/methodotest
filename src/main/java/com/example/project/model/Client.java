package com.example.project.model;

public class Client {
    private int clientId;
    private String nom;
    private String telephone;
    private String email;
    private String password;
    private int pointsFidelite;

    public Client() {}

    public Client(int clientId, String nom, String telephone, String email, String password, int pointsFidelite) {
        this.clientId = clientId;
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
        this.pointsFidelite = pointsFidelite;
    }

    public Client(String nom, String telephone, String email, String password) {
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
        this.pointsFidelite = 0;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPointsFidelite() {
        return pointsFidelite;
    }

    public void setPointsFidelite(int pointsFidelite) {
        this.pointsFidelite = pointsFidelite;
    }

    @Override
    public String  toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", nom='" + nom + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", pointsFidelite=" + pointsFidelite +
                '}';
    }
}
