
#COSAS QUE FALTAN PARA LA PARTE DEL REGISTRO E INICIO DE SESION

[✔] VALIDAR EL INGRESO CON EL TOKEN Y SPRING SECURITY

[✔] VALIDACION DEL CORREO CON UN MODAL QUE PIDA EL CODIGO Y LUEGO DE ELLO RECIEN PUEDA REGISTRARSE

[✔] MOSTRAR QUIEN ES EL USUARIO QUE ESTA INICIANDO SESION

[❌] VALIDAR QUE LOS DATOS INGRESADOS ESTEN TODOS CORRECTAMENTE EN ESPECIAL EL DNI PARA LA CONSULTA CON LA API DE LA RENIEC 


#FUNCIONAMIENTO DE SPRING SECURITY EN EL INICIO DE SESION Y GENERACION DEL TOKEN 

[1] se aplica UserDetails para la entidad cliente y administrador, UserDetails es de Spring Security 
[2] luego creamos un archivo en servicios que es de UserDetailsServiceImpl, en este archivo se va a validar al usuario, se valida por el correo y si no existe pues manda la excepcion de usuario no encontrado
[3]
[4]
[5]
[6]
