package com.sugiartha.juniorandroid;

public class HitungBMI {
    double BMI = 0;
    double beratIdeal;
    double beratBadan;
    double tinggiBadan;

    public HitungBMI(double beratBadan, double tinggiBadan){
        this.beratBadan = beratBadan;
        this.tinggiBadan = tinggiBadan;
    }

    public void setBeratIdeal(double bmi) {
        beratIdeal = 20 * (tinggiBadan*tinggiBadan);
    }

    public double getBMI(){
        String statusBadan;
        BMI = beratBadan/(tinggiBadan*tinggiBadan);
        return BMI;
    }

    public String kesimpulanBMI(double bmi){
        String statusBadan;
        this.setBeratIdeal(bmi);
        if(bmi<18.5){
            statusBadan = "Anda kekurangan berat badan.\n" +
                    "Anda harus menaikkan berat badan sebesar " + (beratIdeal-beratBadan) + " untuk mencapai berat ideal.";
        } else if(bmi>=18.5 && bmi<=24.9){
            statusBadan = "Berat badan anda normal (ideal).";
        } else if(bmi>=25 && bmi<=29.9){
            statusBadan = "Anda kelebihan berat badan. \n" +
                    "Anda harus menurunkan berat badan sebesar " + (beratBadan-beratIdeal) + " untuk mencapai berat ideal.";
        } else {
            statusBadan = "Anda kegemukan (obesitas).\n" +
                    "Anda harus menurunkan berat badan sebesar " + (beratBadan-beratIdeal) + " untuk mencapai berat ideal.";
        }
        return  statusBadan;
    }

}
