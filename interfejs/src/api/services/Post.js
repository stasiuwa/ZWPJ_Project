import axios from "../axios";

export const getAllPosts = async () => { return await axios.get(`/cars/records/all`);};
export const getPosts = async (carID) => { return await axios.get(`/cars/${carID}/records`)}
export const getPost = async (carID, recordID) => { return await axios.get(`/cars/${carID}/records/${recordID}`);};
export const createPost = async (carID, recordData) => { return await axios.post(`/cars/${carID}/records`, recordData);};
export const updatePost = async (carID, recordID, recordData) => { return await axios.put(`/cars/${carID}/records/${recordID}`, recordData);};
export const deletePost = async (carID, recordID) => { return await axios.delete(`/cars/${carID}/records/${recordID}`);};

