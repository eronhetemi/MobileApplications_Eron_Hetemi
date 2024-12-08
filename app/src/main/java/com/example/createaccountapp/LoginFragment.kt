import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.createaccountapp.CredentialsManager
import com.example.createaccountapp.MainActivity
import com.example.createaccountapp.R
import com.example.createaccountapp.RegisterFragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginFragment : Fragment() {

    private lateinit var credentialsManager: CredentialsManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        // Initialize CredentialsManager
        credentialsManager = CredentialsManager(requireContext())

        // Link views
        val emailInput = view.findViewById<TextInputEditText>(R.id.emailEditText)
        val passwordInput = view.findViewById<TextInputEditText>(R.id.passwordEditText)
        val nextButton = view.findViewById<MaterialButton>(R.id.nextButton)
        val newMemberTextView = view.findViewById<TextView>(R.id.newMemberTextView) // Link the Register text view

        // Listener for "Login" button
        nextButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            // Validate email and password
            if (!credentialsManager.isEmailValid(email)) {
                Toast.makeText(requireContext(), "Invalid email format", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!credentialsManager.isPasswordValid(password)) {
                Toast.makeText(requireContext(), "Password cannot be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Check if credentials match
            if (credentialsManager.areCredentialsValid(email, password)) {
                Toast.makeText(requireContext(), "Login Successful!", Toast.LENGTH_SHORT).show()

                // Navigate to MainActivity after login
                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
                requireActivity().finish() // Close the current activity if needed
            } else {
                Toast.makeText(requireContext(), "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }

        // Listener for "New Member? Register now" TextView
        newMemberTextView.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, RegisterFragment()) // Use the correct container ID
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
