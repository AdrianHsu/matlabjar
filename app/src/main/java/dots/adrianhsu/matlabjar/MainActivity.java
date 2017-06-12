package dots.adrianhsu.matlabjar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWClassID;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

import makesqr.Class1;

public class MainActivity extends AppCompatActivity {

    MWNumericArray n = null;
    Object[] result = null;
    Class1 theMagic = null;
    private String[] mystr = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mystr = new String[20];
        mystr[0] = "5";

        try
        {
            n = new MWNumericArray(Double.valueOf(mystr[0]),
                    MWClassID.DOUBLE);

            theMagic = new Class1();
            result = theMagic.makesqr(1, n);
            Log.d("TAG", result[0].toString());
        }
        catch (Exception e)
        {
            System.out.println("Exception: " + e.toString());
        }
        finally
        {
            MWArray.disposeArray(n);
            MWArray.disposeArray(result);
            theMagic.dispose();
        }
    }


}
