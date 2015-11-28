package albert.beta;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import java.util.Random;
import android.view.View.OnClickListener;

public class home extends AppCompatActivity {

    //create variable pointers
    private ImageView appImageView;
    private ImageButton _imgB1;
    private ImageButton _imgB2;
    private ImageButton _imgB3;
    private Button _startGame;
    private Drawable draw;
    private Random random;
    private Drawable [] drawables = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //SAYS EVERY DATA IN THIS ARRAY IS NOW NULL INSTEAD OF ACTUAL PICTURES BEFORE
        drawables = new Drawable[] {
                getResources().getDrawable(R.mipmap.ancient_coin_item),
                getResources().getDrawable(R.mipmap.boots_of_speed_item),
                getResources().getDrawable(R.mipmap.dagger_item),
                getResources().getDrawable(R.mipmap.berserkers_greaves_item)
        };; // create a Drawables array that stores location of different images

        //assign pointer data
        _imgB1 = (ImageButton) findViewById(R.id.imgButton1); //set pointer to img button1
        _imgB2 = (ImageButton) findViewById(R.id.imgButton2);
        _imgB3 = (ImageButton) findViewById(R.id.imgButton3);
        _startGame = (Button) findViewById(R.id.start_game);


        //on button click set image button to random image in the array
        _imgB1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                random = new Random();
                int rand = random.nextInt(drawables.length);
                draw = drawables[rand];
                _imgB1.setImageDrawable(draw); // set the image to the ImageView
            }
        });

        _startGame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                _startGame.setVisibility(View.GONE);
            }
        });
    }
}
