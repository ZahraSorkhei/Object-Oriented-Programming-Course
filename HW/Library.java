import java.util.ArrayList;
import java.util.Scanner;
interface Library{
    int NumbeerOFWorker=15, MasahatSakhteman=500,TedadOjagh=8,MahdoodiatKetab=30;
    void AddBook(book book);
    void LoanBook(book book);
    void TakeBackBook(book book);
    void AddWorker(worker worker);
    void SetPlan();

}
class CentralLibrary implements Library  {
    ArrayList<book> Centerlist = new ArrayList<book>( );
    ArrayList<loanbook> LendingList = new ArrayList<loanbook>( );
    ArrayList<String> loanlistString=new ArrayList<>();
    ArrayList<String> TakeBacklistString=new ArrayList<>();
    ArrayList<worker> WorkerListLending = new ArrayList<worker>( );
    ArrayList<worker> WorkerListBuying = new ArrayList<worker>( );
    ArrayList<worker> WorkerList = new ArrayList<worker>( );
    ArrayList<praffosor> ProffesorList = new ArrayList<praffosor>( );
    ArrayList<student> StudentList = new ArrayList<student>( );
    ArrayList<String> BuyBookString=new ArrayList<String>();
    ArrayList<String> ReturnBookString=new ArrayList<String>();
    ArrayList<book> AllBookForBuy=new ArrayList<book>();
    ArrayList<book> foroosh=new ArrayList<book>();
   public void AddBook(book book) {
        int i=0,j;
        int a[] = new int[10];
        if(SearchBook(book, a)==true){
            // System.out.println("ok3");
            book=Centerlist.get(a[0]);

            i=Centerlist.lastIndexOf(book);
            //System.out.println(i);
            Centerlist.get(i).center++;
            //System.out.println(  Centerlist.get(i).name);
        }
        else {
            // System.out.println("ok2");
            Centerlist.add(book);
            book.center++;
            //System.out.println("**"+book.name);
        }
    }
   public void LoanBook(book book){
        int i=0,j;
        int a[] = new int[10];
        if(SearchBook(book,a)==true){
            book=Centerlist.get(a[0]);
            book.center--;
            // System.out.println("You lend this book");
        }
        else {
            System.out.println("Sorry We don't have that book");
        }
    }
  public void TakeBackSearch(String detail,String library,String identify,String time,int nowday,int day, int month, int year,ALibrary a,BLibrary b){
        int j;
        String s;
        String h[]=time.split(":");
        for(int i=0;i<LendingList.size();i++){
            if(LendingList.get(i).detail.equals(detail)==true&&LendingList.get(i).library.equals(library)==true&&LendingList.get(i).identity.equals(identify)==true){
                if(library.equals("mainLibrary")==true){
                    TakeBackBook(LendingList.get(i).book);
                    LendingList.get(i).NameOfWorker=WorkerList.get(FindWorker(Integer.valueOf(h[0]),nowday)).name;
                    LendingList.get(i).eday=year*365+month*30+day;
                    LendingList.get(i).tahvil=1;
                    s=LendingList.get(i).string.split(",")[4];
                    loanlistString.remove(LendingList.get(i).string);
                    j=FindWorker(Integer.valueOf(time.split(":")[0]),nowday);
                    TakeBacklistString.add(LendingList.get(i).detail+","+LendingList.get(i).NameOfPerson+","+LendingList.get(i).identity+","+s+","+LendingList.get(i).GiveBackDay+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+WorkerList.get(j).name);
                }
                if(library.equals("a")==true){
                    a.TakeBackBook(LendingList.get(i).book);
                    LendingList.get(i).eday=year*365+month*30+day;
                    LendingList.get(i).tahvil=1;
                    s=LendingList.get(i).string.split(",")[5];
                    a.loanlistString.remove(LendingList.get(i).string);
                    j=a.FindWorker(Integer.valueOf(time.split(":")[0]),nowday);
                    a.TakeBacklistString.add(LendingList.get(i).detail+","+LendingList.get(i).NameOfPerson+","+LendingList.get(i).identity+","+s+","+LendingList.get(i).GiveBackDay+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+a.WorkerList.get(j).name);
                }
                if(library.equals("b")==true){
                    b.TakeBackBook(LendingList.get(i).book);
                    LendingList.get(i).eday=year*365+month*30+day;
                    LendingList.get(i).tahvil=1;
                    s=LendingList.get(i).string.split(",")[4];
                    b.loanlistString.remove(LendingList.get(i).string);
                    j=b.FindWorker(Integer.valueOf(time.split(":")[0]),nowday);
                    b.TakeBacklistString.add(LendingList.get(i).detail+","+LendingList.get(i).NameOfPerson+","+LendingList.get(i).identity+","+s+","+LendingList.get(i).GiveBackDay+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+b.WorkerList.get(j).name);
                }
            }
        }
    }
   public void TakeBackBook(book book){
        int i=0,j;
        int a[] = new int[10];
        if(SearchBook(book,a)==true){
            book=Centerlist.get(a[0]);
            book.center++;
            LendingList.remove(book);
            //  System.out.println("Thank you for taking back book");
        }
        else {
            System.out.println("You don't lend this book!:/");
        }
    }
   public void  AddWorker(worker worker){
        WorkerList.add(worker);

            WorkerListLending.add(worker);
            worker.centerposition=1;


            WorkerListBuying.add(worker);
            worker.centerposition=2;

    }
    public void  SetPlan( ){
        //  System.out.println(WorkerList.get(0).being[0]);
        int i=0,z,u=0;
        int hour;
        for(int k=0;k<6;k++){
            for (z=0;z<WorkerList.size();z++){
                //   System.out.println(k);
                if(WorkerList.get(z).being[k]=='1'){

                    i++;
                }
            }
            if(i!=0){
                hour=12/i;
                i=0;
                //System.out.println(hour);
                for (int j=0;j<WorkerList.size();j++){
                    if(WorkerList.get(j).being[k]=='1'){
                        WorkerList.get(j).StartHoure[k]=u*hour+8;
                        WorkerList.get(j).EndHour[k]=(u+1)*hour+8;
                        u++;}
                }
            }
            u=0;
        }


    }
    public  void AddStudent(student student){
        int i,j=0;
        for (i=0;i<StudentList.size();i++){
            if(student.name.equals(StudentList.get(i).name)==true){
                j++;
            }
        }
        if(j==0){
            StudentList.add(student);}
        else{
            System.out.println("Student is already registered!!!");
        }
    }
  public   void AddProfessor(praffosor praffosor){
        int i,j=0;
        for (i=0;i<ProffesorList.size();i++){
            if(praffosor.name.equals(ProffesorList.get(i).name)==true){
                j++;
            }
        }
        if(j==0){
            ProffesorList.add(praffosor);}
        else{
            System.out.println("Student is already registered!!!");
        }
    }
    boolean SearchBook(book book, int[] a){
        int counter=0,counter2=0;
        for (int i=0;i<Centerlist.size();i++){
            if(book.shabak==Centerlist.get(i).shabak){
                counter++;
            }
        }
        if(counter!=0){
            for (int j=0;j<Centerlist.size();j++){
                if(book.DateOfPublishong==Centerlist.get(j).DateOfPublishong){
                    a[0]=j;
                    counter2++;
                }
            }
        }
        if (counter2!=0){
            return true;
        }
        else {
            return false;
        }
    }
    void SearchLoan(String book,String person,String date,int nowday,int day, int month, int year,String library,ALibrary a,BLibrary b){
        int j,z=0,k,p=0;
        String[]o=date.split("\\s");
        String[]d=o[0].split(":");
        int h=Integer.valueOf(d[0]);
        String personmain []=person.split("\\s");
        if(personmain[0].equals("Student")==true){
            for (j=0;j<StudentList.size();j++){
                if(StudentList.get(j).studentnumber.equals(personmain[1])==true){
                    if(StudentList.get(j).budget>-10){
                        p=j;
                        z++;
                    }
                }
            }
        }
        if(personmain[0].equals("Professor")==true){
            for (j=0;j<ProffesorList.size();j++){
                if(ProffesorList.get(j).NationalCode.equals(personmain[1])==true){
                    if(ProffesorList.get(j).budget>-10){
                        p=j;
                        z++;
                    }
                }
            }
        }
        String[]bookmain=book.split(",");
        if(z!=0){
            for (int i=0;i<Centerlist.size();i++){
                if(library.equals("mainLibrary")==true){
                    if(Centerlist.get(i).shabak.equals(bookmain[0])==true&Centerlist.get(i).DateOfPublishong==Integer.valueOf(bookmain[1])){
                        LoanBook(Centerlist.get(i));
                        k=FindWorker(h,nowday);
                        if(personmain[0].equals("Student")==true){
                            loanbook loanbook=new loanbook(book,"Student",StudentList.get(p).studentnumber,o[0],o[1],WorkerList.get(k).name,year,month,day,library,Centerlist.get(i));
                            LendingList.add(loanbook);
                            loanlistString.add(loanbook.detail+","+loanbook.NameOfPerson+","+loanbook.identity+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+o[1]+","+loanbook.NameOfWorker);
                            loanbook.SetString(loanbook.detail+","+loanbook.NameOfPerson+","+loanbook.identity+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+o[1]+","+loanbook.NameOfWorker);
                            //System.out.println(loanlistString.get(0));
                        }
                        if(personmain[0].equals("Professor")==true){
                            loanbook loanbook=new loanbook(book,"Perofessor",StudentList.get(p).studentnumber,o[0],o[1],WorkerList.get(k).name,year,month,day,library,Centerlist.get(i));
                            LendingList.add(loanbook);
                            loanlistString.add(loanbook.detail+","+loanbook.NameOfPerson+","+loanbook.identity+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+o[1]+","+loanbook.NameOfWorker);
                            loanbook.SetString(loanbook.detail+","+loanbook.NameOfPerson+","+loanbook.identity+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+o[1]+","+loanbook.NameOfWorker);
                        }
                    }
                }
                if(library.equals("a")==true){
                    //   System.out.println(Centerlist.get(i).A+"*****");
                    if(Centerlist.get(i).name.equals(bookmain[0])==true&&Centerlist.get(i).DateOfPublishong==Integer.valueOf(bookmain[1])){
                        if(Centerlist.get(i).translater.equals("xxx")==false){
                            if(Centerlist.get(i).translater.equals(bookmain[2])==true){
                                a.LoandBook(Centerlist.get(i));
                                k=a.FindWorker(h,nowday);
                                if(personmain[0].equals("Student")==true){
                                    loanbook loanbook=new loanbook(book,"Student",StudentList.get(p).studentnumber,o[0],o[1],a.WorkerList.get(k).name,year,month,day,library,Centerlist.get(i));
                                    LendingList.add(loanbook);
                                    a.loanlistString.add(loanbook.detail+","+loanbook.NameOfPerson+","+loanbook.identity+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+o[1]+","+loanbook.NameOfWorker);
                                    loanbook.SetString(loanbook.detail+","+loanbook.NameOfPerson+","+loanbook.identity+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+o[1]+","+loanbook.NameOfWorker);
                                    //System.out.println(loanlistString.get(0));
                                }
                                if(personmain[0].equals("Professor")==true){
                                    loanbook loanbook=new loanbook(book,"Perofessor",ProffesorList.get(p).NationalCode,o[0],o[1],a.WorkerList.get(k).name,year,month,day,library,Centerlist.get(i));
                                    LendingList.add(loanbook);
                                    a.loanlistString.add(loanbook.detail+","+loanbook.NameOfPerson+","+loanbook.identity+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+o[1]+","+loanbook.NameOfWorker);
                                    loanbook.SetString(loanbook.detail+","+loanbook.NameOfPerson+","+loanbook.identity+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+o[1]+","+loanbook.NameOfWorker);
                                }
                            }
                        }
                        else {
                            a.LoandBook(Centerlist.get(i));
                            k=a.FindWorker(h,nowday);

                            if(personmain[0].equals("Student")==true){
                                //System.out.println(a.WorkerList.get(k).name);
                                loanbook loanbook=new loanbook(book,"Student",StudentList.get(p).studentnumber,o[0],o[1],a.WorkerList.get(k).name,year,month,day,library,Centerlist.get(i));
                                LendingList.add(loanbook);

                                a.loanlistString.add(loanbook.detail+","+loanbook.NameOfPerson+","+loanbook.identity+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+o[1]+","+loanbook.NameOfWorker);
                                loanbook.SetString(loanbook.detail+","+loanbook.NameOfPerson+","+loanbook.identity+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+o[1]+","+loanbook.NameOfWorker);
                                //System.out.println(loanlistString.get(0));
                            }
                            if(personmain[0].equals("Professor")==true){
                                loanbook loanbook=new loanbook(book,"Perofessor",StudentList.get(p).studentnumber,o[0],o[1],a.WorkerList.get(k).name,year,month,day,library,Centerlist.get(i));
                                LendingList.add(loanbook);
                                a.loanlistString.add(loanbook.detail+","+loanbook.NameOfPerson+","+loanbook.identity+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+o[1]+","+loanbook.NameOfWorker);
                                loanbook.SetString(loanbook.detail+","+loanbook.NameOfPerson+","+loanbook.identity+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+o[1]+","+loanbook.NameOfWorker);
                            }
                        }
                    }
                }
                if(library.equals("b")==true){
                    if(Centerlist.get(i).writer.equals(bookmain[0])==true&&Centerlist.get(i).DateOfPublishong==Integer.valueOf(bookmain[1])){
                        if(Centerlist.get(i).translater.equals("xxx")==false&&bookmain.length>2){
                            if(Centerlist.get(i).translater.equals(bookmain[2])==true){
                                b.LoandBook(Centerlist.get(i));
                                k=b.FindWorker(h,nowday);
                                if(personmain[0].equals("Student")==true){
                                    loanbook loanbook=new loanbook(book,"Student",StudentList.get(p).studentnumber,o[0],o[1],b.WorkerList.get(k).name,year,month,day,library,Centerlist.get(i));
                                    LendingList.add(loanbook);
                                    b.loanlistString.add(loanbook.detail+","+loanbook.NameOfPerson+","+loanbook.identity+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+o[1]+","+loanbook.NameOfWorker);
                                    loanbook.SetString(loanbook.detail+","+loanbook.NameOfPerson+","+loanbook.identity+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+o[1]+","+loanbook.NameOfWorker);
                                    //System.out.println(loanlistString.get(0));
                                }
                                if(personmain[0].equals("Professor")==true){
                                    loanbook loanbook=new loanbook(book,"Perofessor",StudentList.get(p).studentnumber,o[0],o[1],b.WorkerList.get(k).name,year,month,day,library,Centerlist.get(i));
                                    LendingList.add(loanbook);
                                    b.loanlistString.add(loanbook.detail+","+loanbook.NameOfPerson+","+loanbook.identity+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+o[1]+","+loanbook.NameOfWorker);
                                    loanbook.SetString(loanbook.detail+","+loanbook.NameOfPerson+","+loanbook.identity+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+o[1]+","+loanbook.NameOfWorker);
                                }
                            }
                        }
                        else {
                            k=b.FindWorker(h,nowday);
                            if(personmain[0].equals("Student")==true){
                                loanbook loanbook=new loanbook(book,"Student",StudentList.get(p).studentnumber,o[0],o[1],b.WorkerList.get(k).name,year,month,day,library,Centerlist.get(i));
                                LendingList.add(loanbook);
                                a.loanlistString.add(loanbook.detail+","+loanbook.NameOfPerson+","+loanbook.identity+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+o[1]+","+loanbook.NameOfWorker);
                                loanbook.SetString(loanbook.detail+","+loanbook.NameOfPerson+","+loanbook.identity+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+o[1]+","+loanbook.NameOfWorker);
                                //System.out.println(loanlistString.get(0));
                            }
                            if(personmain[0].equals("Professor")==true){
                                loanbook loanbook=new loanbook(book,"Perofessor",ProffesorList.get(p).NationalCode,o[0],o[1],b.WorkerList.get(k).name,year,month,day,library,Centerlist.get(i));
                                LendingList.add(loanbook);
                                b.loanlistString.add(loanbook.detail+","+loanbook.NameOfPerson+","+loanbook.identity+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+o[1]+","+loanbook.NameOfWorker);
                                loanbook.SetString(loanbook.detail+","+loanbook.NameOfPerson+","+loanbook.identity+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+o[1]+","+loanbook.NameOfWorker);
                            }
                        }
                    }
                }


            }
        }
        else{
            System.out.println("Your credit is bellow -10000 ( current credit = -10000.0 )");
        }
    }
    int FindWorker(int h,int day){
        int i,j=0,k;
        for (i=0;i<WorkerList.size();i++){
            if(WorkerList.get(i).being[day]=='1'){
                if(h>=WorkerList.get(i).StartHoure[day]&&h<WorkerList.get(i).EndHour[day]){
                    j=i;
                }
            }
        }
        return j;
    }
    void FindBook(String book,String person){
        String[] personmain;
        String[] bookmain;
        personmain=person.split("\\s");
        bookmain=book.split(",");
        int i,k=0,t=0;
        if(person.contains("Student")){
            for(i=0;i<StudentList.size();i++){
                if (StudentList.get(i).studentnumber.equals(personmain[1])==true){
                    k++;
                }
            }
        }
        if(person.contains("Professor")){
            for(i=0;i<ProffesorList.size();i++){
                if (ProffesorList.get(i).NationalCode.equals(personmain[1])==true){
                    k++;
                }
            }
        }
        if(k!=0){
            for (i=0;i<Centerlist.size();i++){
                if(Centerlist.get(i).name.equals(bookmain[0])==true&&Centerlist.get(i).shabak.equals(bookmain[1])==true&&Centerlist.get(i).DateOfPublishong==Integer.valueOf(bookmain[2])){
                    System.out.println(Centerlist.get(i).library);
                    t++;
                    //   System.out.println(i+"****");
                }
            }
        }

        if(k==0) {
            System.out.println("Not found");
        }
        if(t==0&&k!=0){
            System.out.println("Not found");
        }
        // System.out.println(t+"***");
    }
   public void penalty(int AllDay,int adad){
        for (int i=0;i<LendingList.size();i++){
            if(LendingList.get(i).tahvil==0){
                if(AllDay>LendingList.get(i).day){
                    // System.out.println(LendingList.get(i).day);
                    if(adad<AllDay-LendingList.get(i).day){
                        findperson(LendingList.get(i).NameOfPerson,LendingList.get(i).identity,adad);}
                    else{
                        findperson(LendingList.get(i).NameOfPerson,LendingList.get(i).identity,AllDay-LendingList.get(i).day);
                    }
                }
            }
        }
    }
   public void findperson(String name,String indentify,int d){
        int i,j=0;
        if(name.equals("Student")==true){
            for ( i=0;i<StudentList.size();i++){
                if(indentify==StudentList.get(i).studentnumber){
                    // System.out.println(StudentList.get(i).budget+"**"+i);
                    StudentList.get(i).budget= StudentList.get(i).budget-1000*d;

                    //  System.out.println(d);
                    //   System.out.println(StudentList.get(i).budget);
                }
            }
        }
        if(name.equals("Perofessor")==true){
            for ( i=0;i<ProffesorList.size();i++){
                if(String.valueOf(indentify).equals(ProffesorList.get(i).NationalCode)==true){
                    ProffesorList.get(i).budget= ProffesorList.get(i).budget-1000*d;
                }
            }
        }
    }
    void AddBookForBuy(book book){
        book.foroosh--;
        AllBookForBuy.add(book);
    }
    void kharid(String book,String person,String indentify,String time,int nowday,int year,int month, int day,int fall){
        String BookDetail[]=book.split(",");
        String h[]=time.split(":");
        int z=0;
        int j=0,i=0,k=0,p=0,b=0;
        for (i=0;i<AllBookForBuy.size();i++){
            if(BookDetail[0].equals(AllBookForBuy.get(i).name)==true&&BookDetail[1].equals(AllBookForBuy.get(i).shabak)==true&&Integer.valueOf(BookDetail[2])==AllBookForBuy.get(i).DateOfPublishong){
                b=i;
                k++;

            }

        }
        if(k>0&&person.equals("Student")==true){
            for (i=0;i<StudentList.size();i++){
                if(StudentList.get(i).studentnumber.equals(indentify)==true){
                    p=i;
                    if( StudentList.get(p).budget-AllBookForBuy.get(b).price+AllBookForBuy.get(b).price*fall/100>-10){
                        z++;
                        //System.out.println("**"+StudentList.get(p).budget+"**"+AllBookForBuy.get(b).price+"**"+AllBookForBuy.get(b).price*fall/100);
                        StudentList.get(p).budget=  StudentList.get(p).budget-AllBookForBuy.get(b).price+AllBookForBuy.get(b).price*fall/100;
                        // System.out.println("**"+StudentList.get(p).budget);
                    }
                    else {
                        System.out.println("Your credit is bellow -10000 ( current credit = -10000.0 )");
                    }
                }
            }
        }
        if(k>0&&person.equals("Professor")==true){
            for (i=0;i<ProffesorList.size();i++){
                if(indentify.equals(ProffesorList.get(i).NationalCode)==true){
                    p=i;
                    if( ProffesorList.get(p).budget-AllBookForBuy.get(b).price+AllBookForBuy.get(b).price*fall/100>-10){
                        z++;
                        ProffesorList.get(p).budget=  ProffesorList.get(p).budget-AllBookForBuy.get(b).price+AllBookForBuy.get(b).price*fall/100;}
                    else {
                        System.out.println("your budget not enough");
                    }

                }
            }
        }
        if(z>0){
            AllBookForBuy.get(b).foroosh--;
            i=FindWorker(Integer.valueOf(h[0]),nowday);
            BuyBookString.add(book+","+person+","+indentify+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+String.valueOf(AllBookForBuy.get(b).price-AllBookForBuy.get(b).price*fall/100)+","+WorkerList.get(i).name);

            foroosh.add(AllBookForBuy.get(b));
        }
    }
    void ReturnBook(String book,String person,String indentify,String time,int nowday, int year, int month,int day){
        String bookdatail[]=book.split(",");
        String h[]=time.split(":");
        String data[];
        String tarikh[];
        int j,i,k,o,w;
        double p;
        for( i=0; i<BuyBookString.size();i++){
            if(BuyBookString.get(i).contains(book+","+person+","+indentify)==true){
                data=BuyBookString.get(i).split(",");
                tarikh=data[5].split("/");
                k=365*Integer.valueOf(tarikh[0])+30*Integer.valueOf(tarikh[1])+Integer.valueOf(tarikh[2]);
                j=day-Integer.valueOf(tarikh[2]);
                if(j<6){
                    for (o=0;o<AllBookForBuy.size();o++){
                        if(AllBookForBuy.get(o).name.equals(data[0])==true&&AllBookForBuy.get(o).shabak.equals(data[1])==true&&AllBookForBuy.get(o).DateOfPublishong==Integer.valueOf(data[2])){
                            AllBookForBuy.get(o).foroosh++;
                        }
                    }
                    p=  Double.valueOf(data[6]) -Double.valueOf(data[6])*10*j/100;
                    if(person.equals("Student")==true){
                        for (o=0;o<StudentList.size();o++){
                            if(StudentList.get(o).studentnumber.equals(indentify)==true){
                                StudentList.get(o).budget= StudentList.get(o).budget+p;
                            }
                        }
                    }
                    if(person.equals("Professor")==true){
                        for (o=0;o<ProffesorList.size();o++){
                            if(ProffesorList.get(o).NationalCode.equals(indentify)==true){
                                ProffesorList.get(o).budget= ProffesorList.get(o).budget+p;
                            }
                        }
                    }
                    w=FindWorker(Integer.valueOf(h[0]),nowday);
                    ReturnBookString.add(book+","+person+","+indentify+","+data[5]+","+String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+","+String.valueOf(Double.valueOf(data[6]) -Double.valueOf(data[6])*10*j/100)+","+WorkerList.get(w).name);
                    BuyBookString.remove(i);
                }
            }
        }
    }
    void PrintBookLoan(){
        for (int i=0;i<loanlistString.size();i++){
            System.out.println(loanlistString.get(i));
        }
    }
    void PrintBookback(){
        for (int i=0;i<TakeBacklistString.size();i++){
            System.out.println(TakeBacklistString.get(i));
        }
    }
    void PrintBooksold(){
        for (int i=0;i<BuyBookString.size();i++){
            System.out.println(BuyBookString.get(i));
        }
    }
    void PrintBookreturn(){
        for (int i=0;i<ReturnBookString.size();i++){
            System.out.println(ReturnBookString.get(i));
        }
    }
    void PrintStudent(){
        for(int i=0;i<StudentList.size();i++){
            System.out.println(StudentList.get(i).name+","+StudentList.get(i).studentnumber+" Credit = "+StudentList.get(i).budget);
        }
    }
    void PrintProfessor(){
        for(int i=0;i<ProffesorList.size();i++){
            System.out.println(ProffesorList.get(i).name+","+ProffesorList.get(i).NationalCode+" Credit = "+ProffesorList.get(i).budget);
        }
    }
}
class ALibrary implements Library{
    ArrayList<book> Alist = new ArrayList<book>( );
    ArrayList<String> TakeBacklistString=new ArrayList<>();
    ArrayList<book> LendingList = new ArrayList<book>( );
    ArrayList<String> loanlistString=new ArrayList<>();
    ArrayList<worker> WorkerList = new ArrayList<worker>( );
    public void LoanBook(book book){

    }
    public void AddBook(book book) {
        int i=0,j;
        int a[] = new int[10];
        if(SearchBook(book,a)==true){
            book=Alist.get(a[0]);
            i=Alist.lastIndexOf(book);
            Alist.get(i).center++;
            book.A++;
            //System.out.println("hey");
        }
        else {
            Alist.add(book);
            book.center++;
            book.A++;
            // System.out.println("**+"+book.name);
        }
    }
   public void LoandBook(book book){
        int i=0,j;
        int a[] = new int[10];
        if(SearchBook(book,a)==true){
            book=Alist.get(a[0]);
            book.center--;
            book.A--;
            LendingList.add(book);
            //System.out.println("You lend this book");
        }
        else {
            System.out.println("Sorry We don't have that book");
        }
    }
    public void TakeBackBook(book book){
        int i=0,j;
        int a[] = new int[10];
        if(SearchBook(book,a)==true){
            book=Alist.get(a[0]);
            book.center++;
            book.A++;
            LendingList.remove(book);
            // System.out.println("Thank you for taking back book");
        }
        else {
            System.out.println("You don't lend this book!:/");
        }
    }
    public void  AddWorker(worker worker){
        WorkerList.add(worker);
    }
   public void  SetPlan(){
        //  System.out.println(WorkerList.get(0).being[0]);
        int i=0,z,u=0;
        int hour;
        for(int k=0;k<6;k++){
            for (z=0;z<WorkerList.size();z++){
                //   System.out.println(k);
                if(WorkerList.get(z).being[k]=='1'){

                    i++;
                }
            }
            if(i!=0){
                hour=12/i;
                i=0;
                //System.out.println(hour);
                for (int j=0;j<WorkerList.size();j++){
                    if(WorkerList.get(j).being[k]=='1'){
                        // System.out.println(پنپپ);
                        WorkerList.get(j).StartHoure[k]=u*hour+8;
                        WorkerList.get(j).EndHour[k]=(u+1)*hour+8;
                        u++;
                    }
                }
            }
            u=0;
        }
    }
   public boolean SearchBook(book book,int a[]){
        int counter=0,counter2=0,counter3=0,counter4=0;
        for (int i=0;i<Alist.size();i++){
            if(book.name==Alist.get(i).name){
                counter++;
            }
        }
        if(counter!=0&&book.translater!="xxx"){
            for (int j=0;j<Alist.size();j++){
                if(book.translater==Alist.get(j).translater){
                    counter2++;
                }
            }
        }
        else if(book.translater=="xxx"&&counter!=0){
            counter3++;
        }
        if((counter!=0&&counter2!=0)||(counter3!=0&&counter!=0)){
            for (int j=0;j<Alist.size();j++){
                if(book.translater==Alist.get(j).translater){
                    counter4++;
                    a[0]=j;
                }
            }
        }
        if (counter4!=0){
            return true;
        }
        else {
            return false;
        }
    }
    public int FindWorker(int h,int day){
        int i,j=0,k;
        for (i=0;i<WorkerList.size();i++){
            if(WorkerList.get(i).being[day]=='1'){
                if(h>=WorkerList.get(i).StartHoure[day]&&h<WorkerList.get(i).EndHour[day]){
                    j=i;
                }
            }
        }
        return j;
    }
    void PrintBookLoan(){
        for (int i=0;i<loanlistString.size();i++){
            System.out.println(loanlistString.get(i));
        }
    }
    void PrintBookback(){
        for (int i=0;i<TakeBacklistString.size();i++){
            System.out.println(TakeBacklistString.get(i));
        }
    }
}
class BLibrary implements Library{
    ArrayList<book> Blist = new ArrayList<book>( );
    ArrayList<String> TakeBacklistString=new ArrayList<>();
    ArrayList<book> LendingList = new ArrayList<book>( );
    ArrayList<worker> WorkerList = new ArrayList<worker>( );
    ArrayList<String> loanlistString=new ArrayList<>();
    public void LoanBook(book book){

    }
    public void AddBook(book book) {
        int a[] = new int[10];
        int i=0,j;
        if(SearchBook(book,a)==true){

            book=Blist.get(a[0]);
            i=Blist.lastIndexOf(book);
            Blist.get(i).center++;
            //System.out.println(book.center);
        }
        else {
            Blist.add(book);
            book.center++;
            book.B++;
            // System.out.println(book.name);
        }
    }
    public void LoandBook(book book){
        int i=0,j;
        int a[] = new int[10];
        if(SearchBook(book,a)==true){
            book=Blist.get(a[0]);
            book.center--;
            book.B--;
            LendingList.add(book);
            // System.out.println("You lend this book");
        }
        else {
            System.out.println("Sorry We don't have that book");
        }
    }
   public void TakeBackBook(book book){
        int i=0,j;
        int a[] = new int[10];
        if(SearchBook(book,a)==true){
            book=Blist.get(a[0]);
            book.center++;
            book.B++;
            LendingList.remove(book);
            //  System.out.println("Thank you for taking back book");
        }
        else {
            System.out.println("You don't lend this book!:/");
        }
    }
   public void  AddWorker(worker worker){
        WorkerList.add(worker);
    }
  public   void  SetPlan( ){
        //  System.out.println(WorkerList.get(0).being[0]);
        int i=0,z,u=0;
        int hour;
        for(int k=0;k<6;k++){
            for (z=0;z<WorkerList.size();z++){
                //   System.out.println(k);
                if(WorkerList.get(z).being[k]=='1'){
                    i++;
                }
            }
            if(i!=0){
                hour=12/i;
                i=0;
                //System.out.println(hour);
                for (int j=0;j<WorkerList.size();j++){
                    if(WorkerList.get(j).being[k]=='1'){
                        // System.out.println("ooo"+u);

                        WorkerList.get(j).StartHoure[k]=u*hour+8;
                        WorkerList.get(j).EndHour[k]=(u+1)*hour+8;
                        u++;}
                }
            }
            u=0;
        }
    }
   public boolean SearchBook(book book,int a[]){
        int counter=0,counter2=0,counter3=0,counter4=0;
        for (int i=0;i<Blist.size();i++){
            if(book.writer==Blist.get(i).writer){
                counter++;
            }
        }
        if(counter!=0&&book.translater!="xxx"){
            for (int j=0;j<Blist.size();j++){
                if(book.translater==Blist.get(j).translater){
                    counter2++;
                }
            }
        }
        else if(book.translater=="xxx"&&counter!=0){
            counter3++;
        }
        if((counter!=0&&counter2!=0)||(counter3!=0&&counter!=0)){
            for (int j=0;j<Blist.size();j++){
                if(book.translater==Blist.get(j).translater){
                    counter4++;
                    a[0]=j;
                }
            }
        }
        if (counter4!=0){
            return true;
        }
        else {
            return false;
        }
    }
    public int FindWorker(int h,int day){
        int i,j=0,k;
        for (i=0;i<WorkerList.size();i++){
            //  System.out.println(WorkerList.get(i).being[day]==49);
            if(WorkerList.get(i).being[day]==49){
                if(h>=WorkerList.get(i).StartHoure[day]&&h<WorkerList.get(i).EndHour[day]){
                    j=i;
                }
            }
        }
        return j;
    }
    void PrintBookLoan(){
        for (int i=0;i<loanlistString.size();i++){
            System.out.println(loanlistString.get(i));
        }
    }
    void PrintBookback(){
        for (int i=0;i<TakeBacklistString.size();i++){
            System.out.println(TakeBacklistString.get(i));
        }
    }

}
class book{
    String name,writer,language,translater,library,shabak;
    int NumberOfPages,number, DateOfPublishong,center=0,A=0,B=0,foroosh;
    double price;
    book(String name,int NumberOfPages, int year,String writer,String language ,String shabak,int price,String tanslator){
        this.name=name;
        this.writer=writer;
        this.DateOfPublishong=year;
        this.translater=tanslator;
        this.shabak=shabak;
        this.NumberOfPages=NumberOfPages;
        this.price=price;
        this.language=language;
        this.foroosh=0;

        //  System.out.println(this.name+"\n"+this.NumberOfPages+"\n"+this.DateOfPublishong+"\n"+this.writer+"\n"+this.language+"\n"+this.shabak+"\n"+this.price+"\n"+this.translater);
    }
    book(String name,int NumberOfPages, int year,String writer,String language ,String shabak,int price){
        this.name=name;
        this.writer=writer;
        this.DateOfPublishong=year;
        this.translater="xxx";
        this.shabak=shabak;
        this.NumberOfPages=NumberOfPages;
        this.price=price;
        this.language=language;
        this.foroosh=0;
        //  System.out.println(this.name+"\n"+this.NumberOfPages+"\n"+this.DateOfPublishong+"\n"+this.writer+"\n"+this.language+"\n"+this.shabak+"\n"+this.price+"\n"+this.translater);
    }
    book(String name,String shabak,int year,String writer){
        this.name=name;
        this.writer=writer;
        this.DateOfPublishong=year;
        this.shabak=shabak;
    }
    ArrayList FirstName = new ArrayList( );
    ArrayList LastName = new ArrayList( );

}
class loanbook{
    String string;
    String detail;
    String  NameOfPerson;
    String identity;
    String LoanDate;
    String GiveBackDay;
    String NameOfWorker;
    int houre;
    int day;
    int eday;
    int sday;
    String library;
    int tahvil;
    book book=new book("pp","ppp",1345,"oo");
    loanbook( String detail,String  NameOfPerson, String identity,  String LoanDate,String GiveBackDay,  String NameOfWorker,int day,int month, int year,String library, book book){
        this.book=book;
        this.detail=detail;
        this.NameOfPerson=NameOfPerson;
        this.identity=identity;
        this.LoanDate=LoanDate;
        this.GiveBackDay=GiveBackDay;
        this.NameOfWorker=NameOfWorker;
        String s[]=LoanDate.split(":");
        this.houre=Integer.valueOf(s[0]);
        s=GiveBackDay.split("/");
        this.day=Integer.valueOf(s[0])*365+Integer.valueOf(s[1])*30+Integer.valueOf(s[2]);
        //  System.out.println(Integer.valueOf(s[0])+"**"+Integer.valueOf(s[1])+"***"+Integer.valueOf(s[2]));
        this.sday=365*year+30*month+day;
        this.library=library;
        this.tahvil=0;
        //  System.out.println(detail+"\n"+NameOfPerson+"\n"+identity+"\n"+LoanDate+"\n"+GiveBackDay+"\n"+NameOfWorker+"\n"+houre+"\n"+day);
    }
    void Seteday(String string){
        String s[];
        s=string.split("/");
        this.day=Integer.valueOf(s[0])*356+Integer.valueOf(s[1])*30+Integer.valueOf(s[2]);
    }
    void SetString(String s){
        string=s;
    }
}
class person{
    String name;
    String NationalCode;
    int age;
    String gender;
    double budget;
}
class student extends person{
    String studentnumber;
    int ComingYear;
    String grade;
    String colleg;
    void AddBudget(int a){
        budget=budget+a;
    }
    student(String name,int age,String NationalCode ,String gender,String studentnumber,int ComingYear,String grade,int budget,String colleg){
        this.name=name;
        this.age=age;
        this.NationalCode=NationalCode;
        this.gender=gender;
        this.studentnumber=studentnumber;
        this.ComingYear=ComingYear;
        this.grade=grade;
        this.budget=budget;
        this.colleg=colleg;
        //  System.out.println(this.name+"\n"+this.age+"\n"+this.NationalCode+"\n"+this.gender+"\n"+this.studentnumber+"\n"+this.ComingYear+"\n"+this.grade+"\n"+this.budget+"\n"+this.colleg);

    }

}
class praffosor extends person{
    int ComingYear;
    String colleg;
    praffosor(String name,int age,String NationalCode ,String gender,int ComingYear,int budget,String colleg){
        this.name=name;
        this.age=age;
        this.NationalCode=NationalCode;
        this.gender=gender;
        this.ComingYear=ComingYear;
        this.budget=budget;
        this.colleg=colleg;
        //  System.out.println(this.name+"\n"+this.age+"\n"+this.NationalCode+"\n"+this.gender+"\n"+this.ComingYear+"\n"+this.budget+"\n"+this.colleg);
    }
    void AddBudget(int a){
        budget=budget+a;
    }

}
class worker extends person{
    int centerposition;
    worker(){
        centerposition=0;
    }
    char being[]=new char[6];
    String library;
    int EndHour[]=new int[6];
    int StartHoure[]=new int[6];
    worker(String name,int age,String NationalCode ,String gender,String library){
        this.name=name;
        this.age=age;
        this.NationalCode=NationalCode;
        this.gender=gender;
        this.library=library;
        this.being[0]= this.being[1]= this.being[2]= this.being[3]= this.being[4]= this.being[5]=0;
        // System.out.println(this.name+"\n"+this.age+"\n"+this.NationalCode+"\n"+this.gender+"\n"+this.library);
    }
    void UpdatingBeing(String string){
        being=string.toCharArray();
    }
}
abstract class   store{

    String code;
    int percent;

    void SetCode(String string){

    }
    void buy(String string,int nowday,int year,int month, int day,CentralLibrary mainlibrary){

    }
    void back(String string,int nowday,int year,int month, int day,CentralLibrary mainlibrary){

    }
    boolean CheckCode(String string){
        return true;
    }

}
class store1 extends store{

    String code;
    int percent;
    store1(){
        code=null;
        percent=0;
    }
    void SetCode(String string){
        String main[]=string.split("\\s");
        code=main[0];
        percent=Integer.valueOf(main[1]);
    }
    void buy(String string,int nowday,int year,int month, int day,CentralLibrary mainlibrary){
        int fall;
        String main[]=string.split("\\s");
        if(main.length>6){
            if(CheckCode(main[6])==true){
                fall=percent;
                mainlibrary.kharid(main[2],main[3],main[4],main[5],nowday,year,nowday,day,fall);
            }
            else {
                System.out.println("Invalid Discount Code, Try Again!!!");
                fall=0;
            }
        }
        else {
            fall=0;
            mainlibrary.kharid(main[2],main[3],main[4],main[5],nowday,year,nowday,day,fall);
        }


    }
    void back(String string,int nowday,int year,int month, int day,CentralLibrary mainlibrary){
        String main[]=string.split("\\s");
        mainlibrary.ReturnBook(main[2],main[3],main[4],main[5],nowday,year,month,day);
    }
    boolean CheckCode(String string){
        if(code.equals(string)==true){
            return true;
        }
        else {
            return false;
        }
    }

}
class indentify{
    String string;
    int year;
    int month;
    int day;
    int syear;
    int smonth;
    int sday;
    ArrayList<book> booklist=new ArrayList<book>();
    ArrayList<student> studentlist=new ArrayList<student>();
    ArrayList<praffosor> praffosorlist=new ArrayList<praffosor>();
    ArrayList<worker> workerlist=new ArrayList<worker>();
    void which (String string,CentralLibrary MainLibrary,ALibrary Alibrary,BLibrary BLibrary,store1 s){
        int i=0;
        if(string.contains("Set Date")==true){
            date(string);
        }
        if(string.contains("Create Book")==true){
            //System.out.println("**");
            CreateBook(string);
        }
        if(string.contains("Add Book")==true&&string.contains("Store")==false){
            // System.out.println("**");
            // System.out.println("ok");
            AddBook(string,MainLibrary,Alibrary,BLibrary);
        }
        if(string.contains("Create Person")==true){
            // System.out.println("**");
            // System.out.println("ok");
            CreatePerson (string,MainLibrary);
        }
        if(string.contains("Add Person")==true){
            // System.out.println("**");
            // System.out.println("ok");
            AddPerson (string,MainLibrary,Alibrary,BLibrary);
        }
        if(string.contains("Add Worker")==true){
            // System.out.println("**");
            // System.out.println("ok");
            AddWorker (string,MainLibrary,Alibrary,BLibrary);
        }
        if(string.contains("Deposit")==true){
            // System.out.println("**");
            // System.out.println("ok");
            AddBudeget(string,MainLibrary);
        }
        if(string.contains("Set Schedule")==true){
            // System.out.println("**");
            // System.out.println("ok");
            SetSchedule(string,MainLibrary,Alibrary,BLibrary);
        }
        if(string.contains("Find Book")==true){
            // System.out.println("**");
            // System.out.println("ok");
            FindBook(string,MainLibrary) ;
        }
        if(string.contains("Loan Book")==true){
            LoanBook(string,MainLibrary,Alibrary,BLibrary);
        }
        if(string.contains("GiveBack Book")==true){
            GiveBackBook(string,MainLibrary,Alibrary,BLibrary);
        }
        if(string.contains("Next Day")==true){
            NextDay(string,MainLibrary);
        }
        if(string.contains("Sell Book")==true){
            s.buy(string,nowday(),year,month,day,MainLibrary);
        }
        if(string.contains("GiveBack Store")==true){
            s.back(string,nowday(),year,month,day,MainLibrary);
        }
        if(string.contains("Set DiscountCode")==true){
            s.SetCode(string.split("\\s")[2]+" "+string.split("\\s")[3]);
        }
        if(string.contains("Add Book Store")==true){
            String data[]=string.split("\\s")[4].split(",");
            for (i=0;i<booklist.size();i++){
                if(booklist.get(i).name.equals(data[0])==true&&booklist.get(i).shabak.equals(data[1])==true&&booklist.get(i).DateOfPublishong==Integer.valueOf(data[2])){
                    MainLibrary.AddBookForBuy(booklist.get(i));
                }
            }
        }


    }
    int nowday(){
        return (day-17)%7;
    }
    void date(String string){
        int i=0;
        int j;
        String main;
        String[] date;
        j= string.lastIndexOf("Date");
        main= string.substring(j+5);
        date=main.split("/");
        for(String d:date){
            //  System.out.println(d);
            if(i==0){
                syear=Integer.valueOf(d);
                year=syear;
            }
            if(i==1){
                smonth=Integer.valueOf(d);
                month=smonth;
            }
            if(i==2){
                sday=Integer.valueOf(d);
                day=sday;
            }
            i++;
        }
        //System.out.println(year+"**"+month+"**"+day);
    }
    void CreateBook(String string){
        int i=0;
        int j;
        String main;
        String[] data;
        j= string.indexOf("Book");
        main= string.substring(j+5);
        data=main.split("\\s");
        if(string.contains("persian")==false){

            book book=new book(data[0],Integer.valueOf(data[1]),Integer.valueOf(data[2]),data[3],data[4],data[5],Integer.valueOf(data[6]),data[7]);
            booklist.add(book);

        }
        if(string.contains("persian")==true){

            book book=new book(data[0],Integer.valueOf(data[1]),Integer.valueOf(data[2]),data[3],data[4],data[5],Integer.valueOf(data[6]));
            booklist.add(book);

        }
    }
    void AddBook(String string,CentralLibrary MainLibrary,ALibrary ALibrary,BLibrary BLibrary){
        int i=0,k=0,l=0;
        int j;
        String main, libname,d;
        String[] data;
        j= string.indexOf("Book");
        main= string.substring(j+5);
        j= main.indexOf(" ");
        libname=main.substring(0,j);
        d=main.substring(j+1);
        data=d.split(",");
        //System.out.println(data[0]);
        //   System.out.println(booklist.size());
        for (k=0;k<booklist.size();k++){
            //   System.out.println(booklist.get(k).name.equals(data[0]));
            // System.out.println("uuu");
            if(booklist.get(k).name.equals(data[0])==true&&booklist.get(k).shabak.equals(data[1])==true&&booklist.get(k).DateOfPublishong==Integer.valueOf(data[2])){
                l++;
                if(libname.equals("mainLibrary")==true){
                    // MainLibrary.Centerlist.add(booklist.get(k));
                    MainLibrary.AddBook(booklist.get(k));
                    booklist.get(k).library="mainLibrary";
                    //  System.out.println(  booklist.get(k).center);
                    //  System.out.println("ok1");
                }
                if(libname.equals("a")==true){
                    MainLibrary.AddBook(booklist.get(k));
                    ALibrary.AddBook(booklist.get(k));
                    booklist.get(k).library="a";
                }
                if(libname.equals("b")==true){
                    MainLibrary.AddBook(booklist.get(k));
                    BLibrary.AddBook(booklist.get(k));
                    booklist.get(k).library="b";
                }
            }
        }
        if(l==0){
            System.out.println("Invalid Book's Info");
        }

    }
    void CreatePerson(String string, CentralLibrary MainLibrary){
        int i,z=0;
        String main;
        String[] data;
        if(string.contains("Student")==true){
            i=string.indexOf("Student");
            main=string.substring(i+8);
            data=main.split("\\s");
            // System.out.println(data[4]);
            student student=new student(data[0],Integer.valueOf(data[1]),data[2],data[3],data[4],Integer.valueOf(data[5]),data[6],Integer.valueOf(data[7]),data[8]);
            for(int q=0;q<studentlist.size();q++){
                if(student.name.equals(studentlist.get(q).name)==true){
                    z++;
                }
            }
            if(z==0){
                studentlist.add(student);}

        }
        if(string.contains("Professor")==true){
            i=string.indexOf("Professor");
            main=string.substring(i+10);
            data=main.split("\\s");
            //  System.out.println(data[4]);
            praffosor proffesor =new praffosor(data[0],Integer.valueOf(data[1]),data[2],data[3],Integer.valueOf(data[4]),Integer.valueOf(data[5]),data[6]);
            praffosorlist.add(proffesor);

        }
        if(string.contains("Worker")==true){
            i=string.indexOf("Worker");
            main=string.substring(i+7);
            data=main.split("\\s");
            //  System.out.println(data[4]);
            worker worker =new worker(data[0],Integer.valueOf(data[1]),data[2],data[3],data[4]);
            workerlist.add(worker);
        }

    }
    void  AddBudeget(String string,CentralLibrary MainLibrary){
        int i,j;
        String main;
        String[] data;
        if(string.contains("Student")==true){
            i=string.indexOf("Student");
            main=string.substring(i+8);
            data=main.split("\\s");
            for (j=0;j<studentlist.size();j++){
                if(studentlist.get(j).studentnumber.equals(data[0])==true){
                    studentlist.get(j).AddBudget(Integer.valueOf(data[1]));
                }
            }
        }
        if(string.contains("Professor")==true){
            i=string.indexOf("Professor");
            main=string.substring(i+10);
            data=main.split("\\s");
            for (j=0;j<praffosorlist.size();j++){
                if(praffosorlist.get(j).NationalCode.equals(data[0])==true){
                    praffosorlist.get(j).AddBudget(Integer.valueOf(data[1]));
                }
            }
        }
    }
    void  AddPerson(String string,CentralLibrary MainLibrary,ALibrary ALibrary,BLibrary BLibrary){

        int i,j;
        String main;
        String[] data;
        if(string.contains("Student")==true){

            i=string.indexOf("Student");
            main=string.substring(i+8);
            data=main.split("\\s");
            for (j=0;j<studentlist.size();j++){
                if(studentlist.get(j).studentnumber.equals(data[0])==true){
                    MainLibrary.AddStudent(studentlist.get(j));


                }
            }
        }
        if(string.contains("Professor")==true){
            i=string.indexOf("Professor");
            main=string.substring(i+10);
            data=main.split("\\s");
            for (j=0;j<praffosorlist.size();j++){
                if(praffosorlist.get(j).NationalCode.equals(data[0])==true){
                    MainLibrary.AddProfessor(praffosorlist.get(j));
                }
            }
        }
    }
    void AddWorker(String string,CentralLibrary MainLibrary,ALibrary ALibrary,BLibrary BLibrary){
        int i,j;
        String main;
        String[] data;
        if(string.contains("Worker")==true){
            i=string.indexOf("Worker");
            main=string.substring(i+7);
            data=main.split("\\s");
            for (j=0;j<workerlist.size();j++){
                if(workerlist.get(j).NationalCode.equals(data[0])==true){

                    if(workerlist.get(j).library.equals("a")==true){
                        //System.out.println(workerlist.get(j).library+"***");
                        ALibrary.AddWorker(workerlist.get(j));
                    }
                    if(workerlist.get(j).library.equals("b")==true){
                        BLibrary.AddWorker(workerlist.get(j));
                    }
                    else if(workerlist.get(j).library.equals("mainLibrary")==true){
                        MainLibrary.AddWorker(workerlist.get(j));
                    }
                }
            }
        }
    }
    void SetSchedule(String string,CentralLibrary mainlibrary,ALibrary a,BLibrary b){
        int i;
        String data[]=string.split("\\s");
        for(i=0;i<workerlist.size();i++){
            if(workerlist.get(i).NationalCode.equals(data[2])&&workerlist.get(i).library.equals(data[3])){
                workerlist.get(i).UpdatingBeing(data[4]+data[5]+data[6]+data[7]+data[8]+data[9]);
            }
        }
        mainlibrary.SetPlan();
        a.SetPlan();
        b.SetPlan();
    }
    void  FindBook(String string, CentralLibrary MainLibrary){
        int j ,i;
        String person;
        String book;
        String main=string.substring(10);
        //System.out.println(main.equals("Student"));
        if(main.contains("Student")==true){

            i=main.indexOf("Student");
            book=main.substring(0,i-1);
            person=main.substring(i);
            MainLibrary.FindBook(book,person);
        }
        if(main.contains("Professor")==true){
            i=main.indexOf("Professor");
            book=main.substring(0,i-1);
            person=main.substring(i);
            MainLibrary.FindBook(book,person);
        }

    }
    void LoanBook(String string,CentralLibrary MainLibrary,ALibrary ALibrary,BLibrary BLibrary){
        String data[]=string.split("\\s");
        String book;
        String person;
        String date;
        book=data[2];
        person=data[4].concat(" "+data[5]);
        date=data[6].concat(" "+data[7]);
        MainLibrary.SearchLoan(book,person,date,nowday(),day,month,year,data[3],ALibrary,BLibrary);
    }
    void GiveBackBook(String string,CentralLibrary MainLibrary,ALibrary ALibrary,BLibrary BLibrary){
        String data[]=string.split("\\s");
        MainLibrary.TakeBackSearch(data[2],data[3],data[5],data[6],nowday(),day,month,year,ALibrary,BLibrary);
    }
    void NextDay(String string,CentralLibrary MainLiobrary){
        String[]data =string.split("\\s");
        int plus=1;
        if(data.length>2){
            plus=Integer.valueOf(data[2]);
        }
        else {
            plus=1;
        }
        day=day+plus;

        // System.out.println(day+"***"+month+"***"+year+"***");
        MainLiobrary.penalty(day+month*30+year*365,plus);
    }

}
public class liiib {
    public static void main(String[] arg){
        int i=1;
        ALibrary l1= new ALibrary();
        BLibrary l2= new BLibrary();
        CentralLibrary l= new CentralLibrary();
        indentify first=new indentify();
        store1 s=new store1();
        Scanner imput = new Scanner(System.in).useDelimiter("END");
        String o[]=imput.next().split("\\n");
        System.out.println();
        String u="XXX";
        for (String w:o){
            //  System.out.println(i);
            // System.out.println("^^^"+w+"^^^^");
            first.which(w,l,l1,l2,s);
            i++;
        }
        System.out.println();
        System.out.println("***mainLibrary***");
        System.out.println("***list of loaned books of main library***");
        l.PrintBookLoan();
        System.out.println("***list of given back books of main library***");
        l.PrintBookback();
        System.out.println("***list of sold books of main library***");
        l.PrintBooksold();
        System.out.println("***list of returned books of main library***");
        l.PrintBookreturn();
        System.out.println();
        System.out.println("***a***");
        System.out.println("***list of loaned books of a***");
        l1.PrintBookLoan();
        System.out.println("***list of given back books of a***");
        l1.PrintBookback();
        System.out.println();
        System.out.println("***b***");
        System.out.println("***list of loaned books of b***");
        l2.PrintBookLoan();
        System.out.println("***list of given back books of b***");
        l2.PrintBookback();
        System.out.println();
        System.out.println("***Members***");
        System.out.println("**** Person's Info ****");
        l.PrintStudent();
        l.PrintProfessor();
        //System.out.println(first.day);
    }
}
