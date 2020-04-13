package com.company;

public class Fighter {

    private int fighterID;
    private String firstName;
    private String secondName;
    private String fullName;
    private String nationality;
    private String fightingOut;
    private String Style;
    //private String weightClass;
    private int age;
    private int weight;
    private int height;
    private int winRate;
    private int loseRate;
    private int strength;
    private int speed;
    private int endurance;
    private int submissionDefence;
    private int submissionOffence;

    //private Boolean stance;
    //private Boolean gender;

    public Fighter(int ID, String firName, String secName, String Nation, String fightOut, String fightStyle, int fightAge,
                   int fightWeight, int fightHeight, int fightStrength, int fightSpeed, int fightEndurance, int submissionDef, int submissionOff)
    {
        fighterID = ID;
        firstName = firName;
        secondName = secName;
        fullName = firName + " " + secName;
        nationality = Nation;
        fightingOut = fightOut;
        Style = fightStyle;
        weight = fightWeight;
        //weightClass = weightCla;
        age = fightAge;
        height = fightHeight;
        strength = fightStrength;
        speed = fightSpeed;
        endurance = fightEndurance;
        submissionDefence = submissionDef;
        submissionOffence = submissionOff;

        //stance = fightStance;
        //gender = gen;
    }

    public int getID()
    {
        return fighterID;
    }

    public String getName(){
        return fullName;
    }
    public String getNation(){
        return nationality;
    }
    public String getFightingOut(){
        return fightingOut;
    }
    public String getStyle(){
        return Style;
    }
    public  int getWeight(){
        return weight;
    }
    public int getAge(){
        return age;
    }
    public int getHeight(){
        return height;
    }
    public int getStrength(){
        return this.strength;
    }
    public int getSpeed(){
        return this.speed;
    }
    public int getEndurance(){
        return this.endurance;
    }

    public int getSubmissionDefence() {
        return this.submissionDefence;
    }
    public int getSubmissionOffence() {
        return this.submissionOffence;
    }

    public int getWins(){
        return this.winRate;
    }
    public int getLose(){
        return this.loseRate;
    }

    public void setStrength(int trainedStrength){
        this.strength = trainedStrength;
    }
    public void setSpeed(int trainedSpeed){
        this.speed = trainedSpeed;
    }
    public void setEndurance(int trainedEndurance){
        this.endurance = trainedEndurance;
    }
    public void setSubmissionDefence(int trainedSubDef){
        this.submissionDefence = trainedSubDef;
    }
    public void setSubmissionOffence(int trainedSubOff){
        this.submissionOffence = trainedSubOff;
    }

    public void setWinRate(int FighterwinRate){
        this.winRate = FighterwinRate;
    }

    public void setLoseRate(int FighterloseRate){
        this.loseRate = FighterloseRate;
    }
}
