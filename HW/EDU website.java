import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.ImageIcon;
import  javax.swing.Icon;
import java.awt.Dimension;
import java.util.ArrayList;
class courses{
    String number;
    String group;
    String value;
    String subject;
    String proffesor;
    String exam;
    String time;
    String need;
    String capacity;
    String full;
    String limit;
    courses(String number,String group,String value,String need,String subject,String full,String capacity,String proffesor,String exam,String time,String limit){
        this.number=number;
        this.group=group;
        this.value=value;
        this.subject=subject;
        this.proffesor=proffesor;
        this.exam=exam;
        this.time=time;
        this.need=need;
        this.capacity=capacity;
        this.full=full;
        this.limit=limit;
    }
}
class StringForCources{
    ArrayList<courses> cources1=new ArrayList<courses>();
    void  String(String string) {
        String time = "", limit;
        int i, j;
        if (string.equals("ii") == false){
            String s[] = string.split("\\s");
        if (s[14].equals("دکتر") == true) {
            for (i = 19; i < s.length; i++) {
                time = time + " " + s[i];
            }
            j = time.lastIndexOf(")");
            limit = time.substring(j + 2);
            time = time.substring(0, j + 1);
            courses c = new courses(s[0], s[2], s[4], s[6], s[8], s[10], s[12], s[14] + " " + s[15], s[17], time, limit);
            cources1.add(c);
        }
        if (s[15].equals("دکتر") == true) {
            for (i = 20; i < s.length; i++) {
                time = time + " " + s[i];
            }
            j = time.lastIndexOf(")");
            limit = time.substring(j + 2);
            time = time.substring(0, j + 1);
            courses c = new courses(s[0], s[2], s[4], s[6], s[8] + " " + s[9], s[11], s[13], s[15] + " " + s[16], s[18], time, limit);
            cources1.add(c);
        }
        if (s[16].equals("دکتر") == true) {
            for (i = 21; i < s.length; i++) {
                time = time + s[i] + " ";
            }
            j = time.lastIndexOf(")");
            limit = time.substring(j + 2);
            time = time.substring(0, j + 1);
            courses c = new courses(s[0], s[2], s[4], s[6], s[8] + " " + s[9] + " " + s[10], s[12], s[14], s[16] + " " + s[17], s[19], time, limit);
            cources1.add(c);
        }

    }

    }
    int  search(String number,String group){
        int i,j=-1;
        for (i=0;i<cources1.size();i++){
            if(cources1.get(i).number.equals(number)==true&&cources1.get(i).group.equals(group)==true){
                j=i;
            }
        }
        if(j==-1){
            for (i=0;i<cources1.size();i++){
                if(cources1.get(i).number.equals(number)==true){
                    j=-2;
                }
            }
        }
    return j;
    }

}
class  initial  {
    ArrayList<student> studentlist=new ArrayList<student>();
void  ReadingString(String string,StringForCources R) {
    String[] s = string.split("\\s");
    String[]t;
    int u,a;
    if (s[12].equals("دکتر") == true) {
        student student = new student(s[0], s[1], s[3], s[5], s[12] + " " + s[13], s[7] + " " + s[8], s[10]);
       // System.out.println("**" + s[15]);
      //  System.out.println(student.firstname + "\n" + student.lastname + "\n" + student.stidentnumber + "\n" + student.user + "\n" + student.major + "\n" + student.tend + "\n" + student.master);
        studentlist.add(student);
        if(s[15].equals("--")==false){
            s[15]=s[15].substring(1,s[15].length()-2);
            s[15]=s[15].replace("(","z");
            s[15]=s[15].replace(")","z");
         //   System.out.println(s[15]);
            t=s[15].split("z,z");
            for (int k=0;k<t.length;k++){
               // System.out.println(t[k]);
               t[k]= t[k].replace("z","");
                t[k]=t[k].replace("z","");
                String[] e=t[k].split(",");
            //   System.out.println("&&"+e[0]+"$$"+e[1]);
                a=R.search(e[0],e[1]);
                student.c.add(R.cources1.get(a));
            }

        }
    }
    if (s[12].equals("دکتر") == false) {
        student student = new student(s[0], s[1], s[3], s[5], s[13] + " " + s[14], s[7] + " " + s[8], s[10] +" "+ s[11]);
      //  System.out.println("**" + s[16]);
      //  System.out.println(student.firstname + "\n" + student.lastname + "\n" + student.stidentnumber + "\n" + student.user + "\n" + student.major + "\n" + student.tend + "\n" + student.master);
        studentlist.add(student);
        if(s[16].equals("--")==false){
            s[16]=s[16].substring(1,s[16].length()-2);
            s[16].replace("(","z");
            s[16].replace(")","z");
            t=s[16].split("z,z");
            for (int k=0;k<t.length;k++){
                t[k]= t[k].replace("(","");
                t[k]=t[k].replace(")","");
                String[] e=t[k].split(",");
                // System.out.println("&&"+e[0]+"$$"+e[1]);
                a=R.search(e[0],e[1]);
                student.c.add(R.cources1.get(a));
            }

        }
    }
}
int search(String user,String studentnumber ){
    int o=-1;
    for (int i=0;i<studentlist.size();i++){
        if(studentlist.get(i).user.equals(user)==true&&studentlist.get(i).stidentnumber.equals(studentnumber)==true){

            o=i;
        }
    }
    return o;
}
}
class student{
     String firstname;
     String lastname;
     String stidentnumber;
     String user;
     String  master;

     String major;

     String tend;
     ArrayList<courses> c= new  ArrayList<courses>();
     student(String  firstname,String lastname ,String stidentnumber ,String user,String master,String major,String tren){
         this.firstname=firstname;
         this.lastname=lastname;
         this.stidentnumber=stidentnumber;
         this.user=user;
         this.master=master;
         this.major=major;
         this.tend=tren;
     }

}
 class Test extends JPanel {
    initial in=new initial();
    int o;
     JPanel p;
     JFrame f;
    //MAIN METHOD
    StringForCources R;
    DefaultTableModel model;
    JLabel tedadvahed;
     int TV;
    //CONSTRUCTOR
    public Test(initial in, int o ,StringForCources R,JPanel p,JFrame f)
    {

     int b=1;
        this.o=o;
        this.in=in;
        this.R=R;
        this.p=p;
        this.f=f;
        this.TV=0;
        setLayout(null);
        setBounds(200,200,800,300);
        //ADD SCROLLPANE
        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(70,80,600,400);
        add(scroll);

        //THE TABLE
        final JTable table = new JTable();
        scroll.setViewportView(table);
        scroll.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        //THE MODEL OF OUR TABLE
    model = new DefaultTableModel()
        {
            public Class<?> getColumnClass(int column)
            {
                switch(column)
                {

                    case 11:
                    return Boolean.class;

                    default:
                        return String.class;
                }
            }
        };

        //ASSIGN THE MODEL TO TABLE

        table.setModel(model);
        model.addColumn("شماره درس");
        model.addColumn("گروه");
        model.addColumn("واحد");
        model.addColumn("نام");
        model.addColumn("تعاداد ثبت نامی");
        model.addColumn("نام استاد");
        model.addColumn("زمان امتحان");
        model.addColumn("زمان کلاس");
        model.addColumn("وضعیت");
        model.addColumn("محدودیت");
        model.addColumn("پسشنیازی");
        model.addColumn("حذف");
        //THE ROW
       //   System.out.println(in.studentlist.get(o).c.size());

        for(int i = 0; i < in.studentlist.get(o).c.size(); i++)
        {
            TV=TV+Integer.valueOf(in.studentlist.get(o).c.get(i).value);
            model.addRow(new Object[0]);
            model.setValueAt(false, i, 11);
            model.setValueAt(in.studentlist.get(o).c.get(i).need, i, 10);
            model.setValueAt("Our Row" + (i + 1), i, 1);
            model.setValueAt( in.studentlist.get(o).c.get(i).group, i, 1);
            model.setValueAt( in.studentlist.get(o).c.get(i).value, i, 2);
            model.setValueAt( in.studentlist.get(o).c.get(i).number, i, 0);
            model.setValueAt( in.studentlist.get(o).c.get(i).subject, i, 3);
            model.setValueAt( in.studentlist.get(o).c.get(i).full, i, 4);
            model.setValueAt( in.studentlist.get(o).c.get(i).proffesor, i, 5);
            model.setValueAt( in.studentlist.get(o).c.get(i).exam, i, 6);
            model.setValueAt( in.studentlist.get(o).c.get(i).time, i, 7);

            model.setValueAt("گرفته شده", i, 8);
            model.setValueAt( in.studentlist.get(o).c.get(i).limit, i, 9);
        }

        JLabel shomarh=new JLabel("درس");
        Dimension size= shomarh.getPreferredSize();
        shomarh.setBounds(850,200,size.width,size.height);
        p.add(shomarh);
        JTextField shomarh1=new JTextField(4);
        size= shomarh1.getPreferredSize();
        shomarh1.setBounds(790,200,size.width,size.height);
        p.add(shomarh1);
        JLabel vahed=new JLabel("واحد");
          size= vahed.getPreferredSize();
        vahed.setBounds(720,200,size.width,size.height);
        p.add(vahed);
        JTextField vahed1=new JTextField(4);
        size= vahed1.getPreferredSize();
        vahed1.setBounds(660,200,size.width,size.height);
        p.add(vahed1);
        JLabel group2=new JLabel("گروه");
        size= group2.getPreferredSize();
        group2.setBounds(600,200,size.width,size.height);
        p.add(group2);
        String group1[]={"1","2","3","4"};
        JComboBox group=new JComboBox(group1);
        size= group.getPreferredSize();
        group.setBounds(560, 197,size.width,size.height);
        p.add(group);
        JButton  b1 = new JButton("اضافه");
        size=b1.getPreferredSize();
        b1.setBounds(450,170+size.height,size.width,size.height);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int y;
                y=  R.search(shomarh1.getText(),group.getItemAt(group.getSelectedIndex()).toString());
                if(y==-2){
                    JOptionPane.showMessageDialog(f,
                            "این درس چنین گروهی ندارد",
                            "گروه",
                            JOptionPane.ERROR_MESSAGE);
                    System.out.println("pp");
                }
                if(y==-1){
                    JOptionPane.showMessageDialog(f,
                            "چنین درسی وجود ندارد",
                            "درس",
                            JOptionPane.ERROR_MESSAGE);
                }
                if(y>=0){
                    if(R.cources1.get(y).value.equals(vahed1.getText())==false){
                        JOptionPane.showMessageDialog(f,
                                "واحد درس صحیح نمی باشد",
                                "واحد",
                                JOptionPane.ERROR_MESSAGE);}

                    else {
                        int w=0,z=0,q=0;
                        System.out.println("ok:))))");
                        for(int i = 0; i < in.studentlist.get(o).c.size(); i++){
                            if(R.cources1.get(y).number.equals(in.studentlist.get(o).c.get(i).number)==true&&R.cources1.get(y).group.equals(in.studentlist.get(o).c.get(i).group)==true){
                                w++;
                                JOptionPane.showMessageDialog(f,
                                        "این درس قبلا اخذ شده است",
                                        "تکراری",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        if(w==0){
                            for(int i = 0; i < in.studentlist.get(o).c.size(); i++){
                                if(R.cources1.get(y).number.equals(in.studentlist.get(o).c.get(i).number)==true){
                                    z++;

                                    if(Integer.valueOf(R.cources1.get(y).capacity)-Integer.valueOf(R.cources1.get(y).full)>0){

                                        q++;
                                    in.studentlist.get(o).c.get(i).full=String.valueOf(Integer.valueOf(  in.studentlist.get(o).c.get(i).full)-1);
                                        R.cources1.get(y).full=String.valueOf(Integer.valueOf( R.cources1.get(y).full)+1);
                                        in.studentlist.get(o).c.remove(i);
                                        in.studentlist.get(o).c.add( R.cources1.get(y));
                                    }

                                }
                            }
                        }
                        if(w==0&&z==0){
                            if(Integer.valueOf(R.cources1.get(y).capacity)-Integer.valueOf(R.cources1.get(y).full)>0){
                                R.cources1.get(y).full=String.valueOf(Integer.valueOf( R.cources1.get(y).full)+1);
                            q++;
                            in.studentlist.get(o).c.add(R.cources1.get(y));}
                        }
                        if(q!=0){
                        TV=0;
                            System.out.println("ooooooooo");
                            for(int i = 0; i < in.studentlist.get(o).c.size(); i++)
                            {
                                TV=TV+Integer.valueOf(in.studentlist.get(o).c.get(i).value);

                                model.addRow(new Object[0]);
                                model.setValueAt(false, i, 11);
                                model.setValueAt("", i, 1);
                                model.setValueAt( "", i, 1);
                                model.setValueAt( "", i, 2);
                                model.setValueAt( "", i, 0);
                                model.setValueAt( "", i, 3);
                                model.setValueAt( "", i, 4);
                                model.setValueAt("", i, 5);
                                model.setValueAt("", i, 6);
                                model.setValueAt( "", i, 7);
                                model.setValueAt("", i, 10);
                                model.setValueAt("", i, 8);
                                model.setValueAt( "", i, 9);
                            }
                            TV=0;
                        for(int i = 0; i < in.studentlist.get(o).c.size(); i++)
                        {

                          //  System.out.println("&&"+in.studentlist.get(o).c.size());
                            TV=TV+Integer.valueOf(in.studentlist.get(o).c.get(i).value);

                            model.addRow(new Object[0]);
                            model.setValueAt(false, i, 11);
                            model.setValueAt("Our Row" + (i + 1), i, 1);
                            model.setValueAt( in.studentlist.get(o).c.get(i).group, i, 1);
                            model.setValueAt( in.studentlist.get(o).c.get(i).value, i, 2);
                            model.setValueAt( in.studentlist.get(o).c.get(i).number, i, 0);
                            model.setValueAt( in.studentlist.get(o).c.get(i).subject, i, 3);
                            model.setValueAt( in.studentlist.get(o).c.get(i).full, i, 4);
                            model.setValueAt( in.studentlist.get(o).c.get(i).proffesor, i, 5);
                            model.setValueAt( in.studentlist.get(o).c.get(i).exam, i, 6);
                            model.setValueAt( in.studentlist.get(o).c.get(i).time, i, 7);
                            model.setValueAt(in.studentlist.get(o).c.get(i).need, i, 10);
                            model.setValueAt("گرفته شده", i, 8);
                            model.setValueAt( in.studentlist.get(o).c.get(i).limit, i, 9);
                        }
                        tedadvahed.setText(String.valueOf(TV));
                    }
                    }}
            }
        });
        JButton hazf=new JButton("حذف");
        size=hazf.getPreferredSize();
        hazf.setBounds(200,350,size.width,size.height);
        hazf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int u;
                for (u=in.studentlist.get(o).c.size()-1;u>=0;u--){
                    if(Boolean.valueOf(model.getValueAt(u,11).toString())==true){
                        for(int i = 0; i < in.studentlist.get(o).c.size(); i++)
                        {
                            model.addRow(new Object[0]);
                            model.setValueAt(false, i, 11);
                            model.setValueAt( "", i, 1);
                            model.setValueAt( "", i, 2);
                            model.setValueAt( "", i, 0);
                            model.setValueAt( "", i, 3);
                            model.setValueAt("", i, 4);
                            model.setValueAt( "", i, 5);
                            model.setValueAt( "", i, 6);
                            model.setValueAt("", i, 7);

                            model.setValueAt("", i, 8);
                            model.setValueAt( "", i, 9);
                            model.setValueAt("", i, 10);
                            model.setValueAt(false, i+1, 11);
                        }
                        in.studentlist.get(o).c.get(u).full=String.valueOf(Integer.valueOf(in.studentlist.get(o).c.get(u).full)-1);
                        in.studentlist.get(o).c.remove(u);
                        TV=0;
                        for(int i = 0; i < in.studentlist.get(o).c.size(); i++)
                        {
                            TV=TV+Integer.valueOf(in.studentlist.get(o).c.get(i).value);

                            model.addRow(new Object[0]);
                            model.setValueAt(false, i, 11);
                            model.setValueAt("Our Row" + (i + 1), i, 1);
                            model.setValueAt( in.studentlist.get(o).c.get(i).group, i, 1);
                            model.setValueAt( in.studentlist.get(o).c.get(i).value, i, 2);
                            model.setValueAt( in.studentlist.get(o).c.get(i).number, i, 0);
                            model.setValueAt( in.studentlist.get(o).c.get(i).subject, i, 3);
                            model.setValueAt( in.studentlist.get(o).c.get(i).full, i, 4);
                            model.setValueAt( in.studentlist.get(o).c.get(i).proffesor, i, 5);
                            model.setValueAt( in.studentlist.get(o).c.get(i).exam, i, 6);
                            model.setValueAt( in.studentlist.get(o).c.get(i).time, i, 7);
                            model.setValueAt(in.studentlist.get(o).c.get(i).need, i, 10);
                            model.setValueAt("گرفته شده", i, 8);
                            model.setValueAt( in.studentlist.get(o).c.get(i).limit, i, 9);
                        }
                        tedadvahed.setText(String.valueOf(TV));
                    }
                }
            }
        });
        tedadvahed=new JLabel(String.valueOf(TV));
        size=tedadvahed.getPreferredSize();
        tedadvahed.setBounds(150,400,size.width,size.height);
        p.add(tedadvahed);
        JLabel v=new JLabel("تعداد واحد اخذ شده:");
        size=v.getPreferredSize();
       v.setBounds(180,400,size.width,size.height);
        p.add(v);
        p.add(hazf);
        p.add(b1);


    }
}
class moshakhasat{
    moshakhasat(JFrame f,JPanel p,initial in, int o,StringForCources R,int pos) {

        if (pos == 1){
            int a;
        JLabel l = new JLabel("شماره دانشجو:" + " " + in.studentlist.get(o).stidentnumber);
        Dimension size = l.getPreferredSize();
        l.setBounds(750, 90, size.width, size.height);
        p.add(l);
        JLabel l1 = new JLabel("نام و نام خانوادگی:" + " " + in.studentlist.get(o).firstname + " " + in.studentlist.get(o).lastname);
        size = l1.getPreferredSize();
        l1.setBounds(600, 90, size.width, size.height);
        p.add(l1);
        JLabel l2 = new JLabel("رشته:" + " " + in.studentlist.get(o).major);
        size = l2.getPreferredSize();
        l2.setBounds(475, 90, size.width, size.height);
        p.add(l2);
        JLabel l3 = new JLabel("دانشکده:" + " " + in.studentlist.get(o).major);
        size = l3.getPreferredSize();
        l3.setBounds(325, 90, size.width, size.height);
        p.add(l3);
        JLabel l4 = new JLabel("استاد راهنما:" + " " + in.studentlist.get(o).master);
        size = l4.getPreferredSize();
        l4.setBounds(770, 130, size.width, size.height);
        p.add(l4);
        JLabel l5 = new JLabel("گرایش:" + " " + in.studentlist.get(o).tend);
            size = l5.getPreferredSize();
            l5.setBounds(670, 130, size.width, size.height);
            p.add(l5);
            JLabel l6 = new JLabel("نیمسال دوم 99-98");
            size = l6.getPreferredSize();
            l6.setBounds(770, 150, size.width, size.height);
            p.add(l6);
        // p.add(l1);
        Test tablePanel = new Test(in, o, R, p, f);

        p.add(tablePanel);
    }
    }

}
 class MenuExample implements ActionListener {
    JFrame f;
    JPanel p;
    JMenuBar mb;
    JMenu sabtnam , khadamat, karbar ;
    JMenuItem a1, a2, a3, a4,b1,b2,b3,c1,c2,c3;
    JTextArea ta;
 initial in;
     StringForCources R;
     moshakhasat moshakhasat1;
     JLabel oo=new JLabel("");
 int o;
 void  lable(String s){

 }
    MenuExample(int o,initial in, StringForCources R) {
        this.in=in;
        this.o=o;
        this.R=R;

       p =new JPanel();
        p.setLayout(null);
        f = new JFrame();
        JLabel ll=new JLabel();
        ImageIcon iconLogo = new ImageIcon("E:\\2.PNG");
       ll.setIcon(iconLogo);
        Dimension size= ll.getPreferredSize();
        ll.setBounds(0,0,size.width,size.height);
        p.add(ll);
        a1 = new JMenuItem("در خواست حذف اضطراری");
        a2 = new JMenuItem("ثبت اطلاعات بانکی دانشجو");
        a3 = new JMenuItem("برنامه هفتگی دانشجو");
        a4 = new JMenuItem("ثبت نام");
        a1.addActionListener(this);
        a2.addActionListener(this);
        a3.addActionListener(this);
        a4.addActionListener(this);
        a1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        a2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        a3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        a4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        b1 = new JMenuItem("اطلاعیه و راهنمای  ثبت نام و ترمیم");
        b2 = new JMenuItem("فرم مشاوره انتخاب واحد");
        b3 = new JMenuItem("پرداخت اینترنتی  دانشجویان");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        b2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        b3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        c1 = new JMenuItem("تغییر رمز عبور");
        c2 = new JMenuItem("دریاغت کد اختصاصی");
        c3 = new JMenuItem("پیغامهای دریافتی");
        c1.addActionListener(this);
        c2.addActionListener(this);
        c3.addActionListener(this);
        c1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        c2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        c3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        mb = new JMenuBar();
        mb.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        sabtnam = new JMenu("امور ثبت نام و ترمیم");
        khadamat = new JMenu("خدمات آموزشی");
        karbar = new JMenu("مطلوبات کاربر");
        khadamat.add(a1);
        khadamat.add(a2);
        khadamat.add(a3);
        khadamat.add(a4);
        sabtnam.add(b1);
        sabtnam.add(b2);
        sabtnam.add(b3);
        karbar.add(c1);
        karbar.add(c2);
        karbar.add(c3);
        mb.add(sabtnam);
        mb.add(khadamat);
        mb.add(karbar);
        size= mb.getPreferredSize();
        mb.setBounds(650,45,size.width,size.height);
        JButton b=new JButton();
        p.add(b);
        p.add(mb,BorderLayout.NORTH);
        p.setLayout(null);
        f.add(p);
        f.setSize(900, 700);
        f.setVisible(true);


    }

    public void actionPerformed(ActionEvent e) {
    //   lable(e.getSource().toString());

       // System.out.println(e.getActionCommand());

        int b=0;
        if (e.getSource() == a4){
            oo.setText(e.getActionCommand());
            Dimension size=oo.getPreferredSize();
            oo.setBounds(100,100,size.width,size.height);
            p.add(oo);
          //  System.out.println("ok ok ;)");
            b++;
        moshakhasat1=new moshakhasat(f,p,in,o,R,1);

        }
        if(b==0){
            oo.setText(e.getActionCommand());
            Dimension size=oo.getPreferredSize();
            oo.setBounds(100,100,size.width,size.height);
            p.add(oo);
            JOptionPane.showMessageDialog(f,
                    "شما به این بخش تسترسی ندارید",
                    "دسترسی ",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}

class edu extends JFrame {
        // JTextField
        static JTextField t;
       // static JTextField t1;

        // JFrame
        static JFrame f;

        // JButton
        static JButton b;
         static JButton button1;
        // label to display text
        static JLabel l;
        static JLabel l1;
        static JPasswordField pass;
        static  JLabel t1;
        static  JTextField t3;
        // default constructor
        edu()
        {
        }

        // main class
        public static void main(String[] args)throws Exception
        {
         int i,robat=0;

            int k=0;
            File f1 = new File("E:\\HW.txt");

            BufferedReader br1 = new BufferedReader(new FileReader(f1));

            String st1="ii";
            StringForCources s1=new StringForCources();

            while (st1  != null){
                //  System.out.println(st);
                //   System.out.println(st);

                if(st1!= null&&st1.contains("کاربران")==false&&st1.contains("دروس")==false&&k!=0){
                    // System.out.println(st);
                    s1.String(st1);

                }
                if(st1.contains("دروس")==true&&st1!= null){
                    k++;
                }
                st1 = br1.readLine();
                //   System.out.println(st);
                // String s[]=st.split("\\s");
                // System.out.println("**"+s[0]);}
            }
            // create a new frame to store text field and button
            initial in=new initial();

            File file = new File("E:\\HW.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));

            String st="ii";
            int e=0;
            while (st  != null){

                //   System.out.println(st);

                if(st!= null&&st.contains("کاربران")==false&&st.contains("دروس")==false&&e==0&&st.equals("ii")==false){
                   in.ReadingString(st,s1);
                }
                if(st.contains("دروس")==true){
                    e=1;
                }
                st = br.readLine();
                  //   System.out.println(st);
                   // String s[]=st.split("\\s");
                   // System.out.println("**"+s[0]);}

            }
          //  MenuExample m=new MenuExample(0,in,s1);

            f = new JFrame("https://edu.sharif.edu/");

            // create a label to display text
            l = new JLabel("شناسه کاربر:");
            Dimension size= l.getPreferredSize();
            l.setBounds(210,30,size.width,size.height);
            l1 = new JLabel("رمز عبور:");
             size= l1.getPreferredSize();
            l1.setBounds(210,50,size.width,size.width);
            JLabel l2=new JLabel("متن بالا را وارد کنید:");
             size= l2.getPreferredSize();
           l2.setBounds(150,160,size.width,size.height);
            // create a new button
            b = new JButton("ورود به سیستم");
            size=b.getPreferredSize();
            b.setBounds(85,170+size.height,size.width,size.height);
            // create a object of the text class
            edu te = new edu();
            // addActionListener to button
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int q=0;
                    String s = e.getActionCommand();
                    if (s.equals("ورود به سیستم")) {
                        // set the text of the label to the text of the field
                       // System.out.println(t1.getText());
                        if(t1.getText().equals(t3.getText())==false){
                            JOptionPane.showMessageDialog(f,
                                    "عدد وارد شده با متن هم خوانی ندارد",
                                    "عدد تصادفی ",
                                    JOptionPane.ERROR_MESSAGE);
                            int j=0;
                            Random genarator=new Random();
                            j=genarator.nextInt(9000)+1000;
                            t1.setText(String.valueOf(j));
                            q++;
                        }
                        int u=in.search(pass.getText(),t.getText());
                        if(u==-1){
                            JOptionPane.showMessageDialog(f,
                                    "نام کاربری یا کلمه عبور نادرست است",
                                    "مشخصات ",
                                    JOptionPane.ERROR_MESSAGE);
                            int j=0;
                            Random genarator=new Random();
                            j=genarator.nextInt(9000)+1000;
                            t1.setText(String.valueOf(j));
                        }
                        if(u!=-1&&q==0){
                            f.setVisible(false);
                            //System.out.println("ok:)");
                            MenuExample m=new MenuExample(u,in,s1);
                        }
                    }
                }
            });

            // create a object of JTextField with 16 columns
            t = new JTextField(16);
            size= t.getPreferredSize();
            t.setBounds(20,30,size.width,size.height);

          //  t1 = new JTextField("Password",16);
            pass = new JPasswordField(16);
            size= pass.getPreferredSize();
            pass.setBounds(20,60,size.width,size.height);
             t3=new JTextField(8);
            size =t3.getPreferredSize();
            t3.setBounds(30,160,size.width,size.height);
            Icon icon=new ImageIcon("E:\\icon2.PNG");
            button1=new JButton(icon);
            Random genarator=new Random();
            i=genarator.nextInt(9000)+1000;
             t1 = new JLabel (String.valueOf(i));
             size=t1.getPreferredSize();
             t1.setBounds(150,115,size.width,size.height);
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //System.out.println("pp");
                    int j=0;
                    j=genarator.nextInt(9000)+1000;
                    t1.setText(String.valueOf(j));

                }
            });
          size= button1.getPreferredSize();
          button1.setBounds(75,100,size.width,size.height);

           // button1.setName("robat");
            // create a panel to add buttons and textfield

            JPanel p = new JPanel();
           p.setLayout(null);
            f.getContentPane();
            // add buttons and textfield to panel
            p.add(t);
            p.add(l);
           //  p.add(t0);
            p.add(pass);
            p.add(l1);
            p.add(button1);
            p.add(t1);
            p.add(l2);
            p.add(t3);
            p.add(b);

            // add panel to frame
            f.add(p);

            // set the size of frame
            f.setSize(300, 300);

            f.show();




        }

        // if the vutton is pressed

    }

