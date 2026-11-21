
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function Login() {

  // Store login details
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const navigate = useNavigate();

  // Login the student
  const handleLogin = async (e) => {
    e.preventDefault();

    // Check empty fields
    if (!email.trim() || !password.trim()) {
      alert("Please fill all fields");
      return;
    }

    try {
      // Send login details to backend
      const res = await axios.post(
        "http://localhost:8080/api/auth/login",
        { email, password }
      );

      // Save JWT token
      localStorage.setItem("token", res.data.token);
      // Clear all input fields
      setEmail("");
      setPassword("");
      // Open profile page
      navigate("/profile");

    } catch (error) {
      console.log("Login Error:", error.response || error.message);
      alert(error.response?.data?.message || "Login failed");
    }
  };

  return (
    <div>
      <h2>Student Login</h2>

      <form onSubmit={handleLogin}>
        <input
          type="email"
          placeholder="Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />

        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />

        <button type="submit">Login</button>
      </form>
    </div>
  );
}

export default Login;
