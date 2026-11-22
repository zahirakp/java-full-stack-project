
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import API_URL from "./api";

function Profile() {

  // Store profile details
  const [id, setId] = useState("");
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");

  // Store input values separately
  const [editName, setEditName] = useState("");
  const [editEmail, setEditEmail] = useState("");

  const navigate = useNavigate();

  // Get student profile
  const getProfile = async () => {
    const token = localStorage.getItem("token");

    // Check login token
    if (!token) {
      navigate("/login");
      return;
    }

    try {
      // Get profile from backend
      const response = await axios.get(
        `${API_URL}/api/profile`,
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        }
      );

      // Store profile details
      setId(response.data.id);
      setName(response.data.name);
      setEmail(response.data.email);

      // Store input values
      setEditName(response.data.name);
      setEditEmail(response.data.email);

    } catch (error) {
      console.log("Profile Error:", error.response || error.message);
      alert("Profile loading failed");

      localStorage.removeItem("token");
      navigate("/login");
    }
  };

  // Load profile when page opens
  useEffect(() => {
    getProfile();
  }, []);

  // Update student details
  const handleUpdate = async () => {

    // Check empty fields
    if (!editName.trim() || !editEmail.trim()) {
      alert("Please fill all fields");
      return;
    }

    // Check if details changed
    if (editName === name && editEmail === email) {
      alert("No changes made");
      return;
    }

    try {
      const token = localStorage.getItem("token");

      await axios.put(
        `${API_URL}/api/profile`,
        {
          name: editName.trim(),
          email: editEmail.trim()
        },
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        }
      );

      // Update displayed details
      setName(editName.trim());
      setEmail(editEmail.trim());

      // Clear the input fields
      setEditName("");
      setEditEmail("");

      alert("Profile updated successfully");

    } catch (error) {
      console.log("Update Error:", error.response || error.message);
      alert("Update failed");
    }
  };

  // Logout student
  const handleLogout = () => {
    localStorage.removeItem("token");
    navigate("/login");
  };

  // Delete student account
  const handleDelete = async () => {

    // Ask before deleting
    const confirmDelete = window.confirm(
      "Are you sure you want to delete your account?"
    );

    if (!confirmDelete) {
      return;
    }

    try {
      const token = localStorage.getItem("token");

      await axios.delete(
        `${API_URL}/api/profile`,
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        }
      );

      // Remove login token
      localStorage.removeItem("token");

      alert("Account deleted successfully");

      navigate("/");

    } catch (error) {
      console.log("Delete Error:", error.response || error.message);
      alert("Account deletion failed");
    }
  };

  return (
    <div className="profile-card">
      <h2>My Profile</h2>

      {/* Display profile details */}
      <p>Student ID: {id}</p>
      <p>Name: {name}</p>
      <p>Email: {email}</p>

      {/* Edit student details */}
      <input
        placeholder="Name"
        value={editName}
        onChange={(e) => setEditName(e.target.value)}
      />

      <input
        type="email"
        placeholder="Email"
        value={editEmail}
        onChange={(e) => setEditEmail(e.target.value)}
      />

      <button onClick={handleUpdate}>Update</button> <br /> <br />
      <button onClick={handleLogout}>Logout</button> <br /> <br />
      <button onClick={handleDelete}>Delete Account</button> <br /> <br />
    </div>
  );
}

export default Profile;
