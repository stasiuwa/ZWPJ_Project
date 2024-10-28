import axios from "../axios";

export const loginUser = async (data) => {
    return await axios.post('/login', data);
}
export const logoutUser = async () => {
    return await axios.get('/logout');
}
export const registerUser = async (userData) => {
    return await axios.post('/register', userData);
}
export const getUser = async () =>  {
    return await axios.get('/profile');
}
