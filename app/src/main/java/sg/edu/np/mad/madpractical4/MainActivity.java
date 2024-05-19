package sg.edu.np.mad.madpractical4;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        int randomNumber = getIntent().getIntExtra("RANDOM_NUMBER", 0);

        // Initialize a new User object
        User user= new User("John Doe", "MAD Developer", 1, false );
        // Get the TextViews and Button from the layout
        TextView tvName = findViewById(R.id.textView2);
        TextView tvDescription = findViewById(R.id. textView3);
        Button btnFollow = findViewById(R.id.button);
        Button btnMsg = findViewById(R.id.button2);
        // Set the TextViews with the User's name, description and default button message
        tvName.setText(user.getName() + " " + randomNumber);
        tvDescription.setText(user.getDescription());
        btnFollow.setText(user.isFollowed() ? "Unfollow" : "Follow");
        btnFollow.setOnClickListener(view -> {
            String msg;
            if (!user.isFollowed()) {
                btnFollow.setText("Unfollow");
                msg = "Followed";
            } else {
                btnFollow.setText("Follow");
                msg = "Unfollowed";
            }
            user.setFollowed(!user.isFollowed());

            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        });


    }

}
