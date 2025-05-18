import json

todo_file = "todo_list.json"

def load_tasks():
    try:
        with open(todo_file, "r") as file:
            return json.load(file)
    except (FileNotFoundError, json.JSONDecodeError):
        return []

def save_tasks(tasks):
    with open(todo_file, "w") as file:
        json.dump(tasks, file, indent=4)

def add_task(task):
    tasks = load_tasks()
    tasks.append({"task": task, "done": False})
    save_tasks(tasks)
    print(f"Task added: {task}")

def list_tasks():
    tasks = load_tasks()
    if not tasks:
        print("No tasks found.")
    else:
        for i, task in enumerate(tasks, 1):
            status = "[✓]" if task["done"] else "[ ]"
            print(f"{i}. {status} {task['task']}")

def mark_done(task_number):
    tasks = load_tasks()
    if 0 < task_number <= len(tasks):
        tasks[task_number - 1]["done"] = True
        save_tasks(tasks)
        print("Task marked as done.")
    else:
        print("Invalid task number.")

def delete_task(task_number):
    tasks = load_tasks()
    if 0 < task_number <= len(tasks):
        removed_task = tasks.pop(task_number - 1)
        save_tasks(tasks)
        print(f"Deleted task: {removed_task['task']}")
    else:
        print("Invalid task number.")

def main():
    while True:
        print("\nTo-Do List App")
        print("1. Add Task")
        print("2. List Tasks")
        print("3. Mark Task as Done")
        print("4. Delete Task")
        print("5. Exit")
        choice = input("Choose an option: ")

        if choice == "1":
            task = input("Enter task: ")
            add_task(task)
        elif choice == "2":
            list_tasks()
        elif choice == "3":
            list_tasks()
            try:
                task_number = int(input("Enter task number to mark as done: "))
                mark_done(task_number)
            except ValueError:
                print("Invalid input.")
        elif choice == "4":
            list_tasks()
            try:
                task_number = int(input("Enter task number to delete: "))
                delete_task(task_number)
            except ValueError:
                print("Invalid input.")
        elif choice == "5":
            print("Goodbye!")
            break
        else:
            print("Invalid choice, try again.")

if __name__ == "__main__":
    main()
# Removed invalid JSX-like code and return statement.
print("lla alla") 
print("Rorschach testi gibi bulutlara bak Bazen gereklidir maviliği hissetmelisin")