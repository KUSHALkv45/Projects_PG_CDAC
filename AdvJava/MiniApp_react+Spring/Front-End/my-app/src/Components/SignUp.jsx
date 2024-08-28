import { useState } from 'react';

export default function Signup() {
  const [formData, setFormData] = useState({ username: '', password: '' });

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch('http://localhost:8080/api/signup', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username: formData.username, password: formData.password }),
      });
  
      if (response.ok) {
        const data = await response.json();
        if (data.message === 'User registered successfully') {
          alert('Signup successful!');
          window.location.href = '/login';
        } else {
          alert('Unexpected response: ' + data.message);
          console.log('Unexpected response data:', data);
        }
      } else {
        const errorData = await response.json();
        alert(`Signup failed: ${errorData.message || 'Unknown error'}`);
        console.log('Error data:', errorData);
      }
    } catch (error) {
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
      <button type="submit">Signup</button>
    </form>
  );
}
