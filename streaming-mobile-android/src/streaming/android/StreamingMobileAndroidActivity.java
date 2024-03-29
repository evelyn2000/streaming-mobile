package streaming.android;

import android.app.Activity;
import android.app.Dialog;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class StreamingMobileAndroidActivity extends Activity {
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        setContentView(R.layout.client);
        
        
        //teste
        final Button botaoSetup = (Button) findViewById(R.id.botao_setup);
        botaoSetup.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
				final Dialog dialog = new Dialog(StreamingMobileAndroidActivity.this);
				dialog.setContentView(R.layout.setup);
				dialog.setTitle("Configurar");
				
				Button botaoCancelar = (Button) dialog.findViewById(R.id.botao_cancelar);
				botaoCancelar.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						dialog.cancel();
						
					}
				});
				
				dialog.show();
			}
		});
        
        
        /*final TextView logText = (TextView)findViewById(R.id.texto_log);
        final Button button = (Button)findViewById(R.id.botao_servidor);
        final EditText portaText = (EditText)findViewById(R.id.input_configurar_porta);
        final ScrollView scroll = (ScrollView)findViewById(R.id.scrollView1);*/
        
	
        //log("\nO IP do servidor �: " + this.getIpAddress() + "\n");
        
        /*
        try {
			//Server.start(8812);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        */
        
        /*final StreamingMobileAndroidActivity that = this;
        
        button.setOnClickListener(new View.OnClickListener() {
        	
        	boolean running = false;
        	
            public void onClick(View v) {
            	
            	if(!running) {
	                try {
	                	running = true;
	                	Server.start(Integer.parseInt(portaText.getText().toString()), that);
	                }
	                catch(Exception e){
	                	running = false;
	                	//e.printStackTrace();
	                	log("Erro: " + e.getMessage() + "\n");
	                }
            	}
                
            }
        });*/
        
    }
    
    public void log(String mensagem) {
    	
    	TextView logText = (TextView)findViewById(R.id.texto_log);
        ScrollView scroll = (ScrollView)findViewById(R.id.scrollView1);
    	
    	logText.append(mensagem);
    	//logText.invalidate();
    	scroll.smoothScrollTo(0, logText.getBottom());
    }
    
    public String getIpAddress() {
    	WifiManager myWifiManager = (WifiManager)getSystemService(WIFI_SERVICE);
        
        WifiInfo myWifiInfo = myWifiManager.getConnectionInfo();
        int myIp = myWifiInfo.getIpAddress();
        
        return android.text.format.Formatter.formatIpAddress(myIp);
    }
    
    
}