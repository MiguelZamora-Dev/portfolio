import json
import logging

# GLOBAL VARIABLES
db_employee_route = './db/employees.json'
db_employee_log = './logs/db_accesses.log'

# INITIATE LOGGING
FORMAT = '%(asctime)s => %(message)s'
logging.basicConfig(filename=db_employee_log, encoding='utf-8', format=FORMAT, level=logging.INFO)


class Employee():
    def __init__(self, name, surname, 
    job, job_section, time_worked_here, 
    age, gender, _is_in_project, _what_project_is_in):
        self.name = name
        self.surname = surname
        self.job = job
        self.job_section = job_section
        self.time_worked_here = time_worked_here
        self.age = age
        self.gender = gender
        self._is_in_project = _is_in_project
        self._what_project_is_in = _what_project_is_in
    
    # UPDATE JSON FILE WITH NEW DATA.
    # ARGS: NEW VALUE TO ENTER, KEY TO UPDATE, WHOLE DATA, ROUTE TO THE FILE
    def udpate_db(self, new_data, data_section, data, route):
        previous_data = data[data_section]
        data[data_section] = new_data
        with open(route, 'w') as jsonfile:
            jsonfile.seek(0)
            if data:
                json.dump(data, jsonfile, indent=4)
            jsonfile.close()
            logging.info('Admin updated DB: ' + 
            previous_data + ' => ' + new_data)
        
    # READ JSON FILE
    # ARGS: ROUTE TO THE FILE
    def read_db(self, route):
        with open(route) as jsonfile:
            if jsonfile:
                data = json.loads(jsonfile.read())
                jsonfile.close()
        print(data)

class Admin(Employee):
    def __init__(self, name, surname, 
        job, job_section, time_worked_here, 
        age, gender, _is_in_project, _what_project_is_in, permissions):
        super().__init__(name, surname, 
            job, job_section, time_worked_here, 
            age, gender, _is_in_project, _what_project_is_in)
        self.permissions = permissions

if __name__ == "__main__":
    with open(db_employee_route) as jsonfile:
        if jsonfile:
            data = json.loads(jsonfile.read())
            jsonfile.close()
    admin = Admin(
        name = data['name'], 
        surname = data['surname'], 
        job = data['job'], 
        job_section = data['job_section'], 
        time_worked_here = data['time_worked_here'], 
        age = data['age'],
        gender = data['gender'],
        _is_in_project = data['_is_in_project'],
        _what_project_is_in = data['_what_project_is_in'],
        permissions = data['permissions'])

    #admin.udpate_db('Miguel', 'name', data, db_employee_route)
    #admin.read_db(db_employee_route)

    



    

