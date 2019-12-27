# UnidirectionalDataFlowArchitecture
Unidirectional Data-Flow Architecture on Android using Kotlin Coroutines and Uniflow.This is based on MVI/Flux architecture where Data Model class acts as a state for UI.
View Model act as kind of reducer(like in Redux) which recieves actions(Intents) and modify the state.View listens to State changes and modifies itself as per data.

This sample project uses Uniflow(https://github.com/uniflow-kt/uniflow-kt) which enables Unidirectional architecture.Also used Picasso for Image rendering.
