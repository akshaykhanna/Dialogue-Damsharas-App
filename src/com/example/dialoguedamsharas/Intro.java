package com.example.dialoguedamsharas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Intro extends Activity
{
    Animation obj;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    obj=new Animation(this);
	    setContentView(obj);
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		obj.pause();
		
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		obj.resume();

}

class Animation extends SurfaceView
{
     Thread ourThread; SurfaceHolder sh;
     boolean isRunning=false;
	public Animation(Context context) 
	{
		super(context);
		
		sh=getHolder();
	}
	public void run() 
	{
		while(isRunning)
		{
			if(!sh.getSurface().isValid())
				continue;
			Canvas canvas=sh.lockCanvas();
			
			
		}
		
	}

	public void pause() {
		// TODO Auto-generated method stub
		isRunning=false;
		while(true)
		{
			try {
				ourThread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		ourThread=null;
		
		
		
	}

	public void resume() {
		// TODO Auto-generated method stub
		isRunning=true;
		ourThread=new Thread();
		ourThread.start();
	}

}
}

	
