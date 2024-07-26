(ns hyperstition-goal-graph.web
  (:require [hiccup.page :refer [html5 include-css]]
            [hiccup.form :refer [form-to text-area]]
            [babashka.http-server :as server]
            [cheshire.core :as json]))

(defn page []
  (html5
    [:head
     [:title "Hyperstition Goal Graph Project"]
     (include-css "styles.css")]
    [:body
     [:h1 "Hyperstition Goal Graph Project"]
     [:section
      [:h2 "Objectives"]
      [:h3 "Immediate Goal"]
      [:p "Successfully interact with a goal graph system using Babashka, Ollama, and OpenAI models."]
      [:h3 "Short-Term Goals"]
      [:ul
       [:li "Load and manage a goal graph from an EDN file."]
       [:li "Interact with AI models to process and manage goals."]
       [:li "Create a robust and self-healing system for managing and interacting with the goal graph."]]
      [:h3 "Mid-Term Goals"]
      [:ul
       [:li "Develop multiple interfaces (API, Web UI, Clojure functions) for interacting with the system."]
       [:li "Implement a feedback mechanism to refine and improve the system based on interactions."]]
      [:h3 "Long-Term Goals"]
      [:ul
       [:li "Master the hyperstition goal graph paradigm."]
       [:li "Extend the system's capabilities to manage complex projects and goals."]
       [:li "Ensure the system can scale and handle diverse and large datasets."]]]
     [:section
      [:h2 "Current State"]
      [:h3 "Environment Setup"]
      [:ul
       [:li "Babashka installed using Devbox."]
       [:li "Necessary environment variables (API keys) set up."]]
      [:h3 "Initial Scripts"]
      [:ul
       [:li "foo.clj: Script to load the goal graph from an EDN file."]
       [:li "bar.bb.clj: Script to interact with OpenAI models."]]
      [:h3 "Basic Goal Graph Data"]
      [:p "A sample goal-graph.edn file with nested goals and subgoals."]]
     [:section
      [:h2 "Next Steps"]
      [:ul
       [:li "Fix and test the initial scripts."]
       [:li "Develop additional interfaces (API, Web UI, Clojure functions)."]
       [:li "Implement feedback and self-healing mechanisms."]
       [:li "Extend the goal graph with more detailed and complex goals."]]]
     [:section
      [:h2 "Goals"]
      [:h3 "Short-Term"]
      [:h4 "By End of Week"]
      [:ul
       [:li "Fix and test the initial scripts (foo.clj and bar.bb.clj)."]
       [:li "Create and test the API interface."]
       [:li "Create and test the Web UI interface."]]
      [:h3 "Mid-Term"]
      [:h4 "By End of Month"]
      [:ul
       [:li "Implement feedback and self-healing mechanisms."]
       [:li "Extend the goal graph with more detailed and complex goals."]
       [:li "Ensure robust handling of larger datasets."]
       [:li "Refine and improve the system based on feedback."]]
      [:h3 "Long-Term"]
      [:h4 "By End of Quarter"]
      [:ul
       [:li "Master the hyperstition goal graph paradigm."]
       [:li "Extend the system's capabilities to manage complex projects and goals."]
       [:li "Ensure the system can scale and handle diverse and large datasets."]
       [:li "Develop comprehensive documentation and user guide."]]]
     [:section
      [:h2 "Expected Payoffs"]
      [:h3 "Short-Term"]
      [:ul
       [:li "Functional system for managing and interacting with goals."]
       [:li "Basic understanding of integrating AI models with goal management."]]
      [:h3 "Mid-Term"]
      [:ul
       [:li "Improved system performance and reliability."]
       [:li "Enhanced user experience with multiple interfaces."]
       [:li "Greater control and flexibility in managing complex goals."]]
      [:h3 "Long-Term"]
      [:ul
       [:li "Mastery of the hyperstition goal graph paradigm."]
       [:li "Scalable and robust system capable of handling diverse projects."]
       [:li "Comprehensive tool for personal and professional goal management."]]]
     [:section
      [:h2 "Timeline and Milestones"]
      [:ul
       [:li "Week 1: Fix and test initial scripts, create basic API and Web UI interfaces."]
       [:li "Month 1: Implement feedback mechanisms, extend goal graph, handle larger datasets."]
       [:li "Quarter 1: Master hyperstition goal graph paradigm, extend system capabilities, develop comprehensive documentation."]]]
     [:section
      [:h2 "Action Plan"]
      [:ul
       [:li "Fix and test initial scripts (foo.clj and bar.bb.clj)."]
       [:li "Develop additional interfaces (API, Web UI, Clojure functions)."]
       [:li "Implement feedback and self-healing mechanisms."]
       [:li "Extend the goal graph with more detailed and complex goals."]
       [:li "Refine and improve the system based on feedback."]
       [:li "Document the system and create user guides."]]]
     [:section
      [:h2 "User Input"]
      [:h3 "Paste Your History Here"]
      (form-to [:post "/process"]
               (text-area {:name "user-input"}))
      [:button {:type "submit"} "Submit"]]]))

(defn process-input [input]
  ;; Add your input processing logic here
  (println "Processing user input:" input)
  ;; Return a response
  {:status 200 :headers {"Content-Type" "text/plain"} :body "Input processed successfully"})

(defn handler [req]
  (case (:uri req)
    "/" {:status 200 :headers {"Content-Type" "text/html"} :body (page)}
    "/process" (let [input (get-in req [:params "user-input"])]
                 (process-input input))
    {:status 404 :body "Not Found"}))

(defn start-server []
  (server/start {:port 8080 :handler handler}))

(start-server)
