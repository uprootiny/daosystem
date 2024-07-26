(ns hyperstition-goal-graph
  (:require [babashka.http-client :as http]
            [cheshire.core :as json]))

(def openai-api-key (System/getenv "OPENAI_API_KEY"))

(defn openai-interact [prompt]
  (http/request {:url "https://api.openai.com/v1/completions"
                 :method :post
                 :headers {"Authorization" (str "Bearer " openai-api-key)
                           "Content-Type" "application/json"}
                 :body (json/generate-string {:model "text-davinci-004"
                                              :prompt prompt
                                              :max_tokens 150})}))

(defn interact-with-models [prompt]
  (let [response (openai-interact prompt)]
    (if (:body response)
      (:body response)
      (throw (Exception. "Failed to get response from OpenAI")))))

;; Testing the interaction
(prn (interact-with-models "Explain the concept of hyperstition."))
