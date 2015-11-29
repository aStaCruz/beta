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
    private ImageView _recipeView;
    private ImageButton _imgB1;
    private ImageButton _imgB2;
    private ImageButton _imgB3;
    private Button _startGame;
    private Drawable draw;
    private Random random;
    private Drawable [] drawables = null;
    private _Item [] _recipes = null;
    private _Item []  _berserkerRecipe = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //test data now
        //SAYS EVERY DATA IN THIS ARRAY IS NOW NULL INSTEAD OF ACTUAL PICTURES BEFORE
        drawables = new Drawable[] {
                getResources().getDrawable(R.mipmap.ancient_coin_item),
                getResources().getDrawable(R.mipmap.boots_of_speed_item),
                getResources().getDrawable(R.mipmap.dagger_item),
                getResources().getDrawable(R.mipmap.berserkers_greaves_item)
        }; // create a Drawables array that stores location of different images

        _berserkerRecipe = new _Item[] {
                new _Item("dagger", null, getResources().getDrawable(R.mipmap.dagger_item)),
                new _Item("boots of speed", null, getResources().getDrawable(R.mipmap.boots_of_speed_item))
        };

        _recipes = new _Item [] {
               new _Item("berserker's greaves", _berserkerRecipe, getResources().getDrawable(R.mipmap.berserkers_greaves_item))
        };


        //assign pointer data
        _imgB1 = (ImageButton) findViewById(R.id.imgButton1); //set pointer to img button1
        _imgB2 = (ImageButton) findViewById(R.id.imgButton2);
        _imgB3 = (ImageButton) findViewById(R.id.imgButton3);
        _startGame = (Button) findViewById(R.id.start_game);
        _recipeView = (ImageView) findViewById(R.id.recipe);

        //on button click set image button to random image in the array
        _imgB1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

            }
        });

        _startGame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                _startGame.setVisibility(View.GONE);

                random = new Random();
                int rand = random.nextInt(_recipes.length);
                draw = _recipes[rand].get_image();
                _recipeView.setImageDrawable(draw);


            }
        });
    }
}
