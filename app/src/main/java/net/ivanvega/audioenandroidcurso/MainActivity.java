package net.ivanvega.audioenandroidcurso;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity implements OnPreparedListener, OnCompletionListener {
	MediaPlayer mp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void btnRecurso_click(View v) {
		MediaPlayer mp = MediaPlayer.create
				(this, R.raw.low_rider);
		mp.start();
				
	}
	
	public void btnDispositivo_click(View v) {
		mp = new MediaPlayer();
		
		File dirMusic = Environment.getExternalStoragePublicDirectory
		(Environment.DIRECTORY_MUSIC);
		String ruta = dirMusic.getAbsolutePath() + "/08 En el recuento de los da�os.mp3";
		try {
			mp.setDataSource(ruta);
			mp.setOnCompletionListener(this);
			mp.setOnPreparedListener(this);
			mp.prepareAsync();
			
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onPrepared(MediaPlayer mp) {
		// TODO Auto-generated method stub
		mp.seekTo(1000 * 60 * 4);
		mp.start();
	}

	@Override
	public void onCompletion(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		mp.release();
		mp = null;
		File dirMusic = Environment.getExternalStoragePublicDirectory
		(Environment.DIRECTORY_MUSIC);
		String ruta = dirMusic.getAbsolutePath() + "/06 Searchin.mp3";
		try {
			mp = new MediaPlayer();
			mp.setDataSource(ruta);
			mp.prepareAsync();
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void btnCapturarAudio_click(View v) {
		Intent iCapt =
				new Intent("net.ivanvega.audioenandroidcurso.CAPTURARAUDIO");
		iCapt.putExtra("miparametro", "Este es un parametro pasado");
		startActivity(iCapt);
	}
	
	public void btnTomarPic_click(View v) {
		startActivity(new
				Intent(this, CapturaFoto.class));
	}

	public void video(View v) {
		startActivity(new
				Intent(this, CapturaVideo.class));
	}
}
