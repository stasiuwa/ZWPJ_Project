import axios from "../axios";

export const getAllPosts = async () => { return await axios.get(`/cars/records/all`);};
export const getPosts = async (carID) => { return await axios.get(`/cars/${carID}/records`)}
export const getPost = async (carID, postID) => { return await axios.get(`/cars/${carID}/records/${postID}`);};
export const createPost = async (carID, postData) => { return await axios.post(`/cars/${carID}/records`, postData);};
export const updatePost = async (carID, postID, postData) => { return await axios.put(`/cars/${carID}/records/${postID}`, postData);};
export const deletePost = async (carID, postID) => { return await axios.delete(`/cars/${carID}/records/${postID}`);};

