import { useState } from 'react';

export default function Login() {
  const [formData, setFormData] = useState({ username: '', password: '' });

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
        const response = await fetch('http://localhost:8080/api/login', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(formData),
        });
  
        if (response.ok) {
          const data = await response.json();
          
          // Handle successful login
          alert('Login successful!');
          console.log('Response data:', data);
          
          // Redirect to another page, e.g., dashboard
          window.location.href = 'https://www.google.com';; // Example redirection
        } else {
          // Handle invalid login
          const errorData = await response.json();
          alert(`Login failed: ${errorData.message || 'Invalid username or password'}`);
          console.log('Error data:', errorData);
        }
      } catch (error) {
        // Handle network errors or other unexpected errors
        alert('An error occurred. Please try again later.');
        console.error('Error:', error);
      }
    };
  
  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        placeholder="Username"
        value={formData.username}
        onChange={(e) => setFormData({ ...formData, username: e.target.value })}
      />
      <input
        type="password"
        placeholder="Password"
        value={formData.password}
        onChange={(e) => setFormData({ ...formData, password: e.target.value })}
      />
      <button type="submit">Login</button>
    </form>
  );
}
