package it.step;

public enum Gender {

    M,
    F;


    public String toString() {

        return name();

    }

    public static Gender getGender(String gender) {

        if(gender == "M") {
            return M;
        }else {
            return F;
        }

    }
}
