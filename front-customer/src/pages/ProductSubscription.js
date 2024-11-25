// src/pages/ProductSubscription.js
import React, { useState } from 'react';
import { useLocation } from 'react-router-dom';
import { subscribe } from '../services/api';
import '../styles/productSubscription.css';

const ProductSubscription = () => {
  const { state } = useLocation();
  const insuranceId = state?.insuranceId || ''; // Retrieve insurance ID from state or default to an empty string
  const [form, setForm] = useState({
    insuranceId,
    account: '',
    password: '',
    name: '',
    age: '',
    gender: 'MALE',
    address: '',
    phoneNumber: '',
    job: '',
    email: '',
    birthdate: '',
    creditRating: 'FIRST',
    abroad: 'DOMESTIC',
    crime: 'NO_RECORD',
    disease: 'NO_HISTORY',
    drink: 'NONE',
    drive: 'NON_DRIVER',
    identityNum: '',
    military: 'COMPLETED',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm({
      ...form,
      [name]: value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
  
    console.log('Submitting form data:', {
      insuranceId,
      customerDTO: form,
    });
  
    try {
      const result = await subscribe({ insuranceId, customerDTO: form });
  
      if (result) {
        alert('Subscription successful!');
        setForm({
          insuranceId,
          account: '',
          password: '',
          name: '',
          age: '',
          gender: 'MALE',
          address: '',
          phoneNumber: '',
          job: '',
          email: '',
          birthdate: '',
          creditRating: 'FIRST',
          abroad: 'DOMESTIC',
          crime: 'NO_RECORD',
          disease: 'NO_HISTORY',
          drink: 'NONE',
          drive: 'NON_DRIVER',
          identityNum: '',
          military: 'COMPLETED',
        });
      }
    } catch (error) {
      console.error('Error during subscription:', error);
      alert('Subscription failed. Please try again.');
    }
  };

  return (
    <div className="product-subscription">
      <h1>보험 가입 신청</h1>
      <form onSubmit={handleSubmit} className="subscription-form">
        <label>
          Account:
          <input
            type="text"
            name="account"
            value={form.account}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          Password:
          <input
            type="password"
            name="password"
            value={form.password}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          Name:
          <input
            type="text"
            name="name"
            value={form.name}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          Age:
          <input
            type="number"
            name="age"
            value={form.age}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          Gender:
          <select
            name="gender"
            value={form.gender}
            onChange={handleChange}
            required
          >
            <option value="MALE">Male</option>
            <option value="FEMALE">Female</option>
          </select>
        </label>
        <label>
          Address:
          <input
            type="text"
            name="address"
            value={form.address}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          Phone Number:
          <input
            type="tel"
            name="phoneNumber"
            value={form.phoneNumber}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          Job:
          <input
            type="text"
            name="job"
            value={form.job}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          Email:
          <input
            type="email"
            name="email"
            value={form.email}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          Birthdate:
          <input
            type="date"
            name="birthdate"
            value={form.birthdate}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          Credit Rating:
          <select
            name="creditRating"
            value={form.creditRating}
            onChange={handleChange}
            required
          >
            <option value="FIRST">First</option>
            <option value="SECOND">Second</option>
            <option value="THIRD">Third</option>
            <option value="FOURTH">Fourth</option>
            <option value="FIFTH">Fifth</option>
          </select>
        </label>
        <label>
          Abroad:
          <select
            name="abroad"
            value={form.abroad}
            onChange={handleChange}
            required
          >
            <option value="DOMESTIC">Domestic</option>
            <option value="ABROAD">Abroad</option>
          </select>
        </label>
        <label>
          Crime Record:
          <select
            name="crime"
            value={form.crime}
            onChange={handleChange}
            required
          >
            <option value="NO_RECORD">No Record</option>
            <option value="HAS_RECORD">has Record</option>
          </select>
        </label>
        <label>
          Disease History:
          <select
            name="disease"
            value={form.disease}
            onChange={handleChange}
            required
          >
            <option value="NO_HISTORY">No History</option>
            <option value="HAS_HISTORY">Have History</option>
          </select>
        </label>
        <label>
          Drinking Habit:
          <select
            name="drink"
            value={form.drink}
            onChange={handleChange}
            required
          >
            <option value="NONE">None</option>
            <option value="FREQUENT">FREQUENT</option>
            <option value="MODERATE">MODERATE</option>
            <option value="RARE">RARE</option>
          </select>
        </label>
        <label>
          Driving Habit:
          <select
            name="drive"
            value={form.drive}
            onChange={handleChange}
            required
          >
            <option value="NON_DRIVER">Non-Driver</option>
            <option value="DRIVER">Driver</option>
          </select>
        </label>
        <label>
          Identity Number:
          <input
            type="text"
            name="identityNum"
            value={form.identityNum}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          Military Service:
          <select
            name="military"
            value={form.military}
            onChange={handleChange}
            required
          >
            <option value="COMPLETED">Completed</option>
            <option value="EXEMPTED">Exempted</option>
            <option value="NONE">NONE</option>
          </select>
        </label>
        <button type="submit" className="subscribe-button">Subscribe</button>
      </form>
    </div>
  );
};

export default ProductSubscription;