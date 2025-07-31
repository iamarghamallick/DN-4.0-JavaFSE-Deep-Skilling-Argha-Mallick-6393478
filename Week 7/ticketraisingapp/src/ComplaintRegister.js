import React, { useState } from 'react'

const ComplaintRegister = () => {
    const [formData, setFormData] = useState({ name: '', complaint: '' });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        alert(`Thanks ${formData.name}!\n
            Your complaint was submitted.\n
            Transaction ID: ${new Date().getTime()}`);
    }

    return (
        <form onSubmit={handleSubmit}>
            <label>Name</label>
            <input type="text" placeholder='Name' name='name' value={formData.name} onChange={handleChange} />
            <label>Complaint</label>
            <textarea placeholder='Complaint' name='complaint' value={formData.complaint} onChange={handleChange}></textarea>
            <button type='submit'>Submit</button>
        </form>
    )
}

export default ComplaintRegister