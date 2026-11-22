
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import API_URL from "./api";

function Register() {

  // Store student details
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const navigate = useNavigate();

  // Register the student
  const handleRegister = async (e) => {
    e.preventDefault();

    // Check empty fields
    if (!name.trim() || !email.trim() || !password.trim()) {
      alert("Please fill all fields");
      return;
    }

    try {
      // Send details to backend
      const response = await axios.post(
        `${API_URL}/api/auth/register`,
        { name, email, password }
      );

      // Save login token
      localStorage.setItem("token", response.data.token);

      // Clear all input fields
      setName("");
      setEmail("");
      setPassword("");

      // Open profile page
      navigate("/profile");

    } catch (error) {
      alert(error.response?.data?.message || "Registration failed");
    }
  };

  return (
    <div>
      <h2>Student Register</h2>

      {/* Registration form */}
      <form onSubmit={handleRegister}>

        <input
          placeholder="Name"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />

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

        <button type="submit">Register</button>
      </form>
    </div>
  );
}

export default Register;
