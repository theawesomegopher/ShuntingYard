package ekordik.cuw.edu.shuntingyard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private Queue queue;
    private EditText mathExpression;
    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue = new Queue();
        mathExpression = (EditText)findViewById(R.id.inputMath);
        display = (TextView)findViewById(R.id.txtDisplay);
    }

    public void submit(View view) {
        if(mathExpression.getText().length() > 0) {
            String expression = mathExpression.getText().toString();
            while(expression.length() > 0){
                int index = indexOfOperators(expression);
                if(index > 0) { //If you have valid math expressions this should always be true but if we start with an operator we need this
                    queue.enqueue(expression.substring(0, indexOfOperators(expression)));
                }

                if (index > -1) {
                    queue.enqueue(expression.substring(indexOfOperators(expression), indexOfOperators(expression) + 1));
                    expression = expression.substring(indexOfOperators(expression) + 1);
                } else {
                    queue.enqueue(expression);
                    expression = ""; //All values have been added to the queue so we leave the loop
                }
            }

            display();
        }
    }

    private void display() {
        int size = queue.getCount();
        String expression = "Queue: ";
        for(int i = 0; i < size; i++) {
            String s = queue.dequeue();
            expression += s + " -> ";
            queue.enqueue(s);
        }
        expression += "end";
        display.setText(expression);
    }

    private int indexOfOperators(String s) {
        Pattern pattern = Pattern.compile("[/+*-]");
        Matcher matcher = pattern.matcher(s);

        if(matcher.find()) {
            return matcher.start();
        }
        return -1;
    }


}
