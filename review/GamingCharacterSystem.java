//Character like warrior,mage,archer etc
abstract class GamingCharacterSystem{
    //creating base character abstraction
    abstract void createCharacter(String name,String type);
    abstract void attackBehavior();
}
//implementation of warrior character
class Warrior extends GamingCharacterSystem{
    void createCharacter(String name,String type){
        System.out.println("Character created!");
        System.out.println("Character Name: "+name);
        System.out.println("Character Type: "+type);
    }
    void attackBehavior(){
        System.out.println("Warrior attack with sword!");
    }
    void defendBehavior(){
        System.out.println("Warrior defends with shield!");
    }
    void defendBehavior(String shieldType){
        System.out.println("Warrior defends with "+shieldType+" shield!");
    }
}
//implementation of mage character
class Mage extends GamingCharacterSystem{
    void createCharacter(String name,String type){
        System.out.println("Character created!");
        System.out.println("Character name: "+name);
        System.out.println("Character type:"+type);
    }
    void attackBehavior(){
        System.out.println("Mage attack with magic!");
    }
    void defendBehavior(){
        System.out.println("Mage defends with magic shield!");
    }
    void defendBehavior(String shieldType){
        System.out.println("Mage defends with "+shieldType+" magic shield!");
    }
}
//implementation of archer character
class Archer extends GamingCharacterSystem{
    void createCharacter(String name,String type){
        System.out.println("Character created!");
        System.out.println("Character name: "+name);
        System.out.println("Character type:"+type);
    }
    void attackBehavior(){
        System.out.println("Archer attack with bow!");
    }
    void defendBehavior(){
        System.out.println("Archer defends with shield!");
    }
    void defendBehavior(String shieldType){
        System.out.println("Archer defends with "+shieldType+" shield!");
    }
}
class GamePlay{
    public static void main(String args[]){
        GamingCharacterSystem c1=new Warrior();
        //Creating warrior character
        c1.createCharacter("Thor","Warrior");
        c1.attackBehavior();
        Warrior w=(Warrior)c1;
        w.defendBehavior();
        w.defendBehavior("Iron");
        System.out.println();
        //Creating mage character
        GamingCharacterSystem c2=new Mage();
        c2.createCharacter("Gandalf","Mage");
        c2.attackBehavior();
        Mage m=(Mage)c2;
        m.defendBehavior();
        m.defendBehavior("Energy");
        System.out.println();
        //Creating archer character
        GamingCharacterSystem c3=new Archer();
        c3.createCharacter("Legolas","Archer");
        c3.attackBehavior();
        Archer a=(Archer)c3;
        a.defendBehavior();
        a.defendBehavior("Wooden");
    }
}