package seekbar.matheus.com.seekbar;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity
{

    private SeekBar seekBar;
    private TextView textoExibicao;
    String texto="";
    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        seekBar = (SeekBar) findViewById (R.id.skbDivertidometro);
        textoExibicao = (TextView) findViewById (R.id.txtExibição);


        seekBar.setOnSeekBarChangeListener (new SeekBar.OnSeekBarChangeListener ()
        {
            @Override
            public void onProgressChanged (SeekBar seekBar, int progress, boolean fromUser)
            {
                if(progress <5)
                {
                    texto = ":(";
                }
                else if(progress >=5 && progress<=8)
                {
                    texto = ":)";
                }
                else
                {
                    texto = "=D";
                }
                textoExibicao.setText("Progress: "+progress+"/"+ seekBar.getMax()+"  "+texto);
            }

            @Override
            public void onStartTrackingTouch (SeekBar seekBar)
            {
                Toast.makeText (MainActivity.this,"Down",Toast.LENGTH_SHORT).show ();
            }

            @Override
            public void onStopTrackingTouch (SeekBar seekBar)
            {
                Toast.makeText (getApplicationContext(),"Drop",Toast.LENGTH_SHORT).show ();
            }
        });
    }
}
