
class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity)

        var signupnextbutton = findViewById<Button>(R.id.signuppage_NextButton)

        signupnextbutton.setOnClickListener {
            var intent = Intent(this,ViewPager2::class.java)
            startActivity(intent)
        }
    }
}