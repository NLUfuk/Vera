def main():
    tasks = []

    while True:
        print("\n===== To-Do List =====")
        print("1. Add Task")
        print("2. Show Tasks")
        print("3. Mark Task as Done")
        print("3.1 Clear all tasks")   
        print("4. About Us")
        print("5. Exit")

        choice = input("Enter your choice: ")

        if choice == '1':
            print()
            n_tasks = int(input("How may task you want to add: "))
            
            for i in range(n_tasks):
                task = input("Enter the task: ")
                tasks.append({"task": task, "done": False})
                print("Task added!")

        elif choice == '2':
            print("\nTasks:")
            for index, task in enumerate(tasks):
                status = "Done" if task["done"] else "Not Done"
                print(f"{index + 1}. {task['task']} - {status}")

        elif choice == '3':
            task_index = int(input("Enter the task number to mark as done: ")) - 1
            if 0 <= task_index < len(tasks):
                tasks[task_index]["done"] = True
                print("Task marked as done!")
            else:
                print("Invalid task number.")

        elif choice == '3.1':
            for i in range(len(tasks)):
                print(f"{i + 1}. {tasks[i]['task']} - {tasks[i]['done']}")
            tasks.clear()
            print("All tasks cleared!")
            break
        elif choice == '4':
            print("About us")
            break
        elif choice == '5':
            print("Exiting the To-Do List.")
            break    
        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()