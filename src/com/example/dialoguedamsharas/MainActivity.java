package com.example.dialoguedamsharas;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener 
{
     Random crazy=new Random();
     int wA=0;char el[],count;
     String movieH;
    
	Button hint,enter,skip; EditText movie;TextView dial,hD,sco,Mc;
	String d[]={"Kaun kambakth" +
			" hai jo bardasht karne ke liye peeta hai. Main toh peeta hoon ke bas saans le sakoon.",
	"Bachpan se hi naa ... mujhe shaadi karne kaa bahut craze hai, by god",
	"Utaar ke fenk do ye wardi aur pahan lo balwant rai ka patta apne gale mein…",
	"Chal Hata Sawan ki Ghata, Khaal Khuja Batti buja ke soja nintukle pintukle, Vanti pe khadeli he banti baja rahi hai baar baar ghanti kulla mila ke paschim ko palatle… Bahut ho gaya phut le vat le…Chal jaa yaha se … Hawa ande yaar….",
"Yeh Dhai kilo ka haath jab kisipe padtha hai na…toh aadmin ut-tha nahi ud jaata hai",
" Mogambo khush hua",
"Hachkiyaan, hachkiyyan main hu nandu sabkla bandhu",
"Aap ne mujhe 5 minute diya than a sadhe 4 minute main sab khatam kar diya. 30 second munafa yahi hota hai business aur agar iske liye bhi aap mujhe sazaa sena chahe to de dijiye",
"Aj Khush to bohot hoge tum",
"Main chhota sa, pyaara sa, nanha sa munna sa bacha hoon",
"Hum jaha pe khade ho jaate hein, line wahi se shuru hoti hai",
"Sapne bhi samundar ki lahron ki tarah, haqeeqat ki chattanon se takra kar toot jaate hain",
"Apun ko question poochne ka hai, koi mar rela ho to usko form bharna zaroori hai kya",
"Ullu-gadhaa-paagal toh mein bhi keh sakta tha -lekin mujhe pata hai, jo shakal se aap lagte hain, woh hain nahi",
"Haan Mein...Magar Woh...Lekin Mein...Kyonki Woh...Tumne Toh...Sunoh Toh... !!!",
};

	String m[]={"Devdas","Jab We Met","Ghayal","Deewane Mastane","Damini","Mr. India","Raja Babu","Guru",
			"Deewar","Chaalbaaz","Kaaliya","Deewar","Muna Bhai MBBS","Andaz Apna Apna",
			"Dil Chahta Hai",};
	String hints[];
	int c,ld,ld2,score=0,h=0;
	Data obj;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ac);
		 //ld=d.length;
		 obj=new Data();
		 d=obj.d1;
		 m=obj.m1;
		 ld=d.length;
		intialise();
		nextq();
		
		
	}

	private void intialise() 
	{
		// TODO Auto-generated method stub
		hint=(Button)findViewById(R.id.bHint);
		enter=(Button)findViewById(R.id.bEnter);
		skip=(Button)findViewById(R.id.bSkip);
		movie=(EditText)findViewById(R.id.etMovie);
		dial=(TextView)findViewById(R.id.tvDial);
		sco=(TextView)findViewById(R.id.tvScore);
		Mc=(TextView)findViewById(R.id.tvMcode);
		hint.setOnClickListener(this);
		enter.setOnClickListener(this);
		skip.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) 
	{
		// TODO Auto-generated method stub
		switch(arg0.getId())
		{
		case R.id.bEnter:
			String check=movie.getText().toString();
			Context context = getApplicationContext();
			char el[]=check.toCharArray();
			
			if(check.length()==1)
			{
				la2(check.charAt(0));
			}
			//letter arranging algo
			
			else
			{
			if(m[c].equalsIgnoreCase(check))
			{
				
				Toast toast=Toast.makeText(context, "Woopie! "+m[c]+", correct answer",2000);
				toast.show();
				d[c]="*";//removing that dilaouge when answer is correct
				wA++;
				score+=50;
				sco.setText("Score "+score);
				movie.setText("");
				if(score==100)
				{
					d=obj.d2;
					m=obj.m2;
					hints=obj.h2;
					ld=d.length;
					wA=wA-2;
				}
				
				if(wA>=(ld-1))
				{
					Toast toast3=Toast.makeText(context, "Game Completed!",1000);
					toast3.show();
					finish();
				}
				if(score%100==0)
				{
					h=h+2;
					
					Toast toast2=Toast.makeText(context, "You earned +1 Hints!",1000);
					toast2.show();
					
				}
				nextq();
			   
			    
			}
			else
			{
				Toast toast4=Toast.makeText(context, "Wrong!, Try again..",1000);
				toast4.show();
			}}
			break;
		case R.id.bHint:
			AlertDialog ad = new AlertDialog.Builder(this).create(); 
		if(h>0)
			{
		    
		    
		    ad.setMessage("Dialog By: "+hints[c]);
		    ad.show();
			h--;
			}
		else 
		{
			ad.setMessage("Sorry!, No hint left");
		    ad.show();
		}
			break;
		case R.id.bSkip:
			nextq();
			break;
		}
		
	}

	

	private <check> void la2(char check) {
		// TODO Auto-generated method stub
		String temp="";
		for(int i=0;i<m[c].length();i++)
	    {
	    	if(check == m[c].charAt(i))
	    	{  count=0;
	    		while(count<movieH.length())
	    		{
	    			if(count!=i)
	    			temp=temp+movieH.charAt(count);
	    			else
	    				temp=temp+m[c].charAt(i);
	    			count++;
	    			
	    		}
	    		movieH=temp;
	    	}
	    }
		Mc.setText(movieH);
	}

	private void nextq() {
		
		 do
		 {
			 c=crazy.nextInt(ld);
		 }while(d[c].equalsIgnoreCase("*"));
		    dial.setText(d[c]);
		    letterArrange();
		   
		    
	}
	private void letterArrange() {
		// letter arrange algo
		movieH="";
		for(int i=0;i<m[c].length();i++)
	    {
	    	char oc=m[c].charAt(i);
	    	if(oc!='a'&&oc!='e'&&oc!='i'&&oc!='o'&&oc!='u'&&oc!=' ')
	    		movieH+='-';
	    	else
	    		movieH+=oc;
	    }
	    Mc.setText(movieH);
	   
	}
}
