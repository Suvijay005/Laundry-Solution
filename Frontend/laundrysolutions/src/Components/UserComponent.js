import React from "react";
import App from "../App";

import UserService from "../Services/UserService";

class UserComponent extends React.Component{

constructor(props){
super(props)
    this.state={
        users:[]
    }
}

componentDidMount(){
    UserService.getUsers().then((response)=>{

        this.setState({users: response.data})
    });
}



render(){
    return(
        <div>
           <h1 className="text-center">users List</h1>
            <table className="table table-striped">
            <thead>

                 <tr>
                    <td>User id</td>
                    <td>firstName</td>
                    <td>lastName</td>
                    <td>email</td>
                    <td>contactNo</td>
                    <td>role</td>
                 </tr>

            </thead>
            <tbody>
                {

                this.state.users.map(

                 user =>
                 <tr key={user.id}>
                    <td>{user.id}</td>
                    <td>{user.firstName}</td>
                    <td>{user.lastName}</td>
                    <td>{user.email}</td>
                    <td>{user.contactNo}</td>
                    <td>{user.role}</td>
                 </tr>
                )
                }

            </tbody>

            </table>

        </div>
    )
}




}

export default UserComponent