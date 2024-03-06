import java.util.HashMap;
import java.util.Map;


class ATMMachine{
public static class ATM {
   int totalBalance;
   Map<Integer,Integer> notesList;
   ATM(){
    totalBalance=0;
    notesList=new HashMap<>();
    notesList.put(500, 0);
    notesList.put(200, 0);
    notesList.put(100, 0);
    notesList.put(50, 0);
    notesList.put(20, 0);
    notesList.put(10, 0);
   }
    void deposit(int[] denomination){

        //10 notes
        notesList.put(10, notesList.get(10)+denomination[0]);
        totalBalance+=denomination[0]*10;
        //20 notes
        notesList.put(20, notesList.get(20)+denomination[1]);
        totalBalance+=denomination[1]*20;
        //50 notes
        notesList.put(50, notesList.get(50)+denomination[2]);
        totalBalance+=denomination[2]*50;
        //100 notes
        notesList.put(100, notesList.get(100)+denomination[3]);
        totalBalance+=denomination[3]*100;
        //200 notes
        notesList.put(200, notesList.get(200)+denomination[4]);
        totalBalance+=denomination[4]*200;
        //500 notes
        notesList.put(500, notesList.get(500)+denomination[5]);
        totalBalance+=denomination[5]*500;
        
        
    }

    int[] withdraw(int amount){
        int[] notes={-1,-1,-1,-1,-1,-1};
       if(amount%10!=0){
        System.out.println("entered amount can not be withdrawn");
        
        return notes;
       }
       if(amount>totalBalance){
        System.out.println("insufficient balance");
        return notes;
       }
       //update bank balance
       totalBalance=totalBalance-amount;
       //500 notes
       int notes500=-1;
       notes500=amount/500;
       if(notesList.get(500)<notes500){
        notes500=notesList.get(500);
        notesList.put(500, 0);
        amount=amount-(notes500*500);

       }else{
        notesList.put(500,notesList.get(500)-notes500);
        amount=amount-(notes500*500);
       }
        //200 notes
        int notes200=-1;
        notes200=amount/200;
        if(notesList.get(200)<notes200){
         notes200=notesList.get(200);
         notesList.put(200, 0);
         amount=amount-(notes200*200);
        }else{
         notesList.put(200,notesList.get(200)-notes200);
         amount=amount-(notes200*200);
        }
        //100 notes
        int notes100=-1;
        notes100=amount/100;
        if(notesList.get(100)<notes100){
         notes100=notesList.get(100);
         notesList.put(100, 0);
         amount=amount-(notes100*100);
        }else{
         notesList.put(100,notesList.get(100)-notes100);
         amount=amount-(notes100*100);
        }
        //50 notes
        int notes50=-1;
        notes50=amount/50;
        if(notesList.get(50)<notes50){
         notes50=notesList.get(50);
         notesList.put(50, 0);
         amount=amount-(notes50*50);
        }else{
         notesList.put(50,notesList.get(50)-notes50);
         amount=amount-(notes50*50);
        }
        //20 notes
        int notes20=-1;
        notes20=amount/20;
        if(notesList.get(20)<notes20){
         notes20=notesList.get(20);
         notesList.put(20, 0);
         amount=amount-(notes20*20);
        }else{
         notesList.put(20,notesList.get(20)-notes20);
         amount=amount-(notes20*20);
        }
        //10 notes
        int notes10=-1;
        notes10=amount/10;
        if(notesList.get(10)<notes10){
         notes10=notesList.get(10);
         notesList.put(10, 0);
         amount=amount-(notes10*10);
        }else{
         notesList.put(10,notesList.get(10)-notes10);
         amount=amount-(notes10*10);
        }

        
        int[] withdrawAmt={notes10,notes20,notes50,notes100,notes200,notes500};
       


       return withdrawAmt;

       
    }


}


  public static void main(String[] args) {
     ATM atm=new ATM();
     int[] depositAmt={10,3,5,40,50,90};
     atm.deposit(depositAmt);
     System.out.println("total account balance is :"+atm.totalBalance);
     int[] withdrawAmt=atm.withdraw(50550);
     System.out.println("notes inorder of 10 20 50 100 200 500");
     for(int i=0;i<6;i++){
        System.out.print(withdrawAmt[i]+" ");
     }
     System.out.println();
     System.out.println("total account balance is :"+atm.totalBalance);
     
  }

}

